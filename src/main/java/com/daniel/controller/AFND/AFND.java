package com.daniel.controller.AFND;

import com.daniel.controller.TransitionTable.State;
import com.daniel.controller.TransitionTable.Transition;
import com.daniel.controller.Tree.Node;

import java.util.*;

public class AFND {

    public ArrayList<State> states;
    public Set<String> alphabet;
    public ArrayList<Transition> transitions;
    private int stateCount = 0;
    public State finalState;
    public State initialState;
    private final String EPSILON = "ε";
    public String name;

    public AFND(){
        this.states = new ArrayList<>();
        this.transitions = new ArrayList<>();
    }

    public void addAllStates(ArrayList<State> states){
        for (State s : states) {
            this.addState(s);
        }
    }

    public void addState(State s) {
        s.number = stateCount;
        this.states.add(s);
        stateCount++;
    }

    public State addState() {
        State s = new State(stateCount);
        this.states.add(s);
        stateCount++;
        return s;
    }

    public State addInitialState() {
        State s = this.addState();
        this.initialState = s;
        return s;
    }

    public State addFinalState() {
        State s = this.addState();
        this.finalState = s;
        return s;
    }

    public void concat(AFND left, AFND right){
        this.initialState = left.initialState;
        this.finalState = right.finalState;
        this.addAllStates(left.states);

        for(State s : right.states){
            if(!s.equals(right.initialState)){
                this.addState(s);
            }
        }

        // Add left transitions
        this.transitions.addAll(left.transitions);

        // Concat left final to right initial and the rest of right transitions
        for(Transition t : right.transitions){
            if(t.getCurrentState().equals(right.initialState)) {
                this.insertTransition(left.finalState, t.getCharacterString(), t.getNextState());
            }else{
                this.insertTransition(t.getCurrentState(), t.getCharacterString(), t.getNextState());
            }
        }
    }

    public void union(AFND left, AFND right){

        this.initialState = this.addState(); // NEW INIT
        this.finalState = this.addState(); // NEW FINAL

        this.insertTransition(this.initialState, this.EPSILON, left.initialState); // INIT -> LEFT INIT
        this.insertTransition(this.initialState, this.EPSILON, right.initialState); // INIT -> RIGHT INIT

        this.insertTransition(left.finalState,this.EPSILON, this.finalState); // LEFT FINAL -> FINAL
        this.insertTransition(right.finalState,EPSILON, this.finalState); // RIGHT FINAL -> FINAL

        this.addAllStates(left.states); // ADD LEFT STATES
        this.addAllStates(right.states); // ADD RIGHT STATES

        // Add left transitions
        this.transitions.addAll(left.transitions);

        // Add right transitions
        this.transitions.addAll(right.transitions);
    }

    public void nodei(Node token){
        State initJoin = this.addInitialState();
        State finalJoin = this.addFinalState();
        this.insertTransition(initJoin, token.lexeme.toString(), finalJoin);
    }

    public void plus(AFND ndfa){

        this.initialState = this.addInitialState(); // New init
        this.finalState = this.addFinalState(); // New final

        this.addAllStates(ndfa.states); // ADD AFND STATES

        // Add all AFND transitions
        this.transitions.addAll(ndfa.transitions);

        // new init to AFND init
        this.insertTransition(this.initialState, EPSILON, ndfa.initialState);

        // AFND final to AFND init with epsilon
        this.insertTransition(ndfa.finalState, EPSILON, ndfa.initialState);

        // AFND final to new final
        this.insertTransition(ndfa.finalState, EPSILON, this.finalState);
    }

    public void kleene(AFND ndfa){
        this.initialState = this.addInitialState(); // New init
        this.finalState = this.addFinalState(); // New final

        this.addAllStates(ndfa.states); // ADD AFND STATES

        // Add all AFND transitions
        this.transitions.addAll(ndfa.transitions);

        // new init to AFND init
        this.insertTransition(this.initialState, EPSILON, ndfa.initialState);

        // AFND final to AFND init with epsilon
        this.insertTransition(ndfa.finalState, EPSILON, ndfa.initialState);

        // AFND final to new final
        this.insertTransition(ndfa.finalState, EPSILON, this.finalState);

        // new init to new final
        this.insertTransition(this.initialState, EPSILON, this.finalState);
    }

    public void optional(AFND ndfa){

        this.initialState = this.addInitialState(); // New init
        this.finalState = this.addFinalState(); // New final

        this.addAllStates(ndfa.states); // ADD AFND STATES

        // Add all AFND transitions
        this.transitions.addAll(ndfa.transitions);

        // new init to AFND init
        this.insertTransition(this.initialState, EPSILON, ndfa.initialState);

        // AFND final to new final
        this.insertTransition(ndfa.finalState, EPSILON, this.finalState);

        // new init to new final
        this.insertTransition(this.initialState, EPSILON, this.finalState);
    }
    
    public void insertTransition(State currentState, String symbol, State nextState){
        Transition transition = new Transition(currentState, symbol, nextState);
        this.transitions.add(transition);
    }

    public State insertState(int number){
        State state = new State(number);
        this.states.add(state);
        return state;
    }

    public String getNameRegex() {
        return name;
    }

    public Set<Transition> getTransitionsFromState(State state){
        Set<Transition> transitionsFromState = new HashSet<>();
        for (Transition transition: transitions){
            if (transition.getCurrentState().equals(state)){
                transitionsFromState.add(transition);
            }
        }
        return transitionsFromState;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("States: ").append(states).append("\n");
        sb.append("Alphabet: ").append(alphabet).append("\n");
        for (State state: states){
            sb.append("Transitions from ").append(state).append(": ").append(getTransitionsFromState(state)).append("\n");
        }
        return sb.toString();
    }
}
