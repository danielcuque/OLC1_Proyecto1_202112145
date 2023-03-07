package com.daniel.controller.TransitionTable;

import java.util.ArrayList;
import java.util.List;

public class TransitionTable {

    private final List<State> states;
    private final List<Character> inputs;
    private int[][] transitions;

    public TransitionTable(List<Character> inputs) {
        this.inputs = inputs;
        this.states = new ArrayList<>();
        this.transitions = new int[0][inputs.size()];
    }

    public void addState(State state) {
        states.add(state);
        int[][] newTransitions = new int[states.size()][inputs.size()];
        for (int i = 0; i < transitions.length; i++) {
            System.arraycopy(transitions[i], 0, newTransitions[i], 0, transitions[i].length);
        }
        transitions = newTransitions;
    }

    public void addTransition(int from, int to, char input) {
        int inputIndex = inputs.indexOf(input);
        transitions[from][inputIndex] = to;
    }

    // Getters
    public List<State> getStates() {
        return states;
    }

    public List<Character> getInputs() {
        return inputs;
    }

    public int[][] getTransitions() {
        return transitions;
    }

}
