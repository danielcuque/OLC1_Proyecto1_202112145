package com.daniel.controller.DFA;

import com.daniel.controller.TransitionTable.State;
import com.daniel.controller.TransitionTable.Transition;
import com.daniel.controller.TransitionTable.TransitionTable;

import java.util.Objects;
import java.util.Set;

public class DFA {
    public State initialState;
    public Set<State> states;
    public Set<State> finalStates;
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

    public boolean accept(String input) {
            State currentState = initialState;

            for (String c : input.split("")) {
                boolean transitionFound = false;

                for (Transition t : transitionTable.transitions) {
                    if (t.getCurrentState().equals(currentState) && Objects.equals(t.getCharacter(), c)) {
                        currentState = t.getNextState();
                        transitionFound = true;
                        break;
                    }
                }

                if (!transitionFound) {
                    return false;
                }
            }

            return finalStates.contains(currentState);
        }
}
