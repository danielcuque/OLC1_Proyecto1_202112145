package com.daniel.controller.TransitionTable;


public class Transition {
    private State currentState;
    private String character;
    private State nextState;

    public Transition(State currentState, String character, State nextState) {
        this.currentState = currentState;
        this.character = character;
        this.nextState = nextState;
    }

    // Getters
    public State getCurrentState() {
        return currentState;
    }

    public String getCharacter() {
        return character;
    }

    public State getNextState() {
        return nextState;
    }

    @Override
    public String toString() {
        return "Transition{\n" +
                "currentState=" + currentState + ",\n" +
                ", character='" + character + '\'' + "\n" +
                ", nextState=" + nextState + "\n" +
                '}';
    }
}
