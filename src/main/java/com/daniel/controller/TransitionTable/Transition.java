package com.daniel.controller.TransitionTable;


import com.daniel.controller.Conjuntos.Conjunto;

public class Transition {
    private State currentState;
    private Object character;
    private State nextState;

    public Transition(State currentState, Object character, State nextState) {
        this.currentState = currentState;
        this.character = character;
        this.nextState = nextState;
    }

    // Getters
    public State getCurrentState() {
        return currentState;
    }

    public Object getCharacter() {
        return character;
    }

    public String getCharacterString() {
        if (character instanceof Conjunto){
            return ((Conjunto) character).identifier;
        }
        return (String) character;
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
