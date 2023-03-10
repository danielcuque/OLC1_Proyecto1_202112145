package com.daniel.controller.DFA;

import com.daniel.controller.Conjuntos.Conjunto;
import com.daniel.controller.TransitionTable.State;
import com.daniel.controller.TransitionTable.Transition;
import com.daniel.controller.TransitionTable.TransitionTable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DFA {
    public State initialState;
    public Set<State> states;
    public Set<State> finalStates = new HashSet<>();
    public TransitionTable transitionTable;

    public DFA(TransitionTable transitionTable) {
        this.transitionTable = transitionTable;
        this.states = transitionTable.states;
        calculateFinalStates();
        this.initialState = transitionTable.initialState;
    }

    public State getInitialState(){
        return this.transitionTable.initialState;
    }

    public void calculateFinalStates(){
        for (State state: states){
            if (state.isAccepting){
                finalStates.add(state);
            }
        }
    }
    public String getName(){
        return this.transitionTable.name;
    }

    public Set<String> getLexemes (){
        return this.transitionTable.getLexemes();
    }

    public Set<State> getStates(){
        return this.transitionTable.states;
    }

    public Set<State> getFinalStates(){
        return this.finalStates;
    }

    public State getState(int number){
        for (State state: states){
            if (state.getNumber() == number){
                return state;
            }
        }
        return null;
    }

    public Set<Transition> getTransitions(){
        return this.transitionTable.transitions;
    }

    public boolean accept(String input) {
            State currentState = initialState;

            for (String c : input.split("")) {
                boolean transitionFound = false;

                for (Transition t : transitionTable.transitions) {
                    if(t.getCurrentState().getNumber() == currentState.getNumber()) {
                        if (t.getCharacter() instanceof Conjunto conjunto) {
                            if (conjunto.contains(c)) {
                                currentState = t.getNextState();
                                transitionFound = true;
                                break;
                            }
                        } else {
                            if (t.getCharacter() instanceof String s && Objects.equals(s, c)) {
                                currentState = t.getNextState();
                                transitionFound = true;
                                break;
                            }
                        }
                    }
                }

                if (!transitionFound) {
                    return false;
                }
            }

            return finalStates.contains(currentState);
        }
}
