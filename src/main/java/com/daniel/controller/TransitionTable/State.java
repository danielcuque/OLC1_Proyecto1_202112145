package com.daniel.controller.TransitionTable;

import java.util.HashSet;
import java.util.Set;

public class State {

    public int number;
    public Set<Integer> follows;
    public boolean isAccepting = false;


    public State(int number) {
        this.number = number;
        this.follows = new HashSet<>();
    }


    @Override
    public String toString() {
        return "q" + number;
    }

    // Getters
    public int getNumber() {
        return number;
    }


}
