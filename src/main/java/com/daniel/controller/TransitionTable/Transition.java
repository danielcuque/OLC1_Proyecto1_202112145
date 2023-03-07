package com.daniel.controller.TransitionTable;

public class Transition {
    private final char value;

    public Transition(char value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transition transition = (Transition) o;

        return value == transition.value;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }

    // Getters
    public char getValue() {
        return value;
    }
}
