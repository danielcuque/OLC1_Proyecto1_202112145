package com.daniel.controller.TransitionTable;

import com.daniel.controller.Tree.Node;

import java.util.HashSet;
import java.util.Set;

public class State {

    private final int number;

    // El estado va a guardar follows
    public Set<Integer> follows;

    public State(int number) {
        this.number = number;
        this.follows = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Q" + number;
    }

    // Getters
    public int getNumber() {
        return number;
    }
}
