package com.daniel.controller.Tree;

import java.util.HashSet;
import java.util.Set;

public class State {
    public int number;
    public boolean isAccepted = false;
    public Set<Integer> follows = new HashSet<>();


    public State(int number, Set<Integer> follows) {
        this.number = number;
        this.follows = follows;
    }

    public State(int number, boolean isAccepted) {
        this.number = number;
        this.isAccepted = isAccepted;
    }


}
