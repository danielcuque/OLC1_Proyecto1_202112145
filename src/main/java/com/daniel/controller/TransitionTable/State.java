package com.daniel.controller.TransitionTable;

import java.util.HashSet;
import java.util.Set;

public class State {

    private final int number;
    public Set<Integer> follows;
    public boolean isAccepting = false;

    public String lexeme;

    public State(int number) {
        this.number = number;
        this.follows = new HashSet<>();
    }

    public State(int number, boolean isAccepting, String lexeme) {
        this.number = number;
        this.isAccepting = isAccepting;
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return "q" + number;
    }

    // Getters
    public int getNumber() {
        return number;
    }

    public void setAccepting(boolean accepting) {
        isAccepting = accepting;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }



}
