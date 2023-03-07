package com.daniel.controller.TransitionTable;

import com.daniel.controller.Tree.Node;

import java.util.HashSet;
import java.util.Set;

public class State {

    private final int number;
    private final Set<Node> nodes;

    public State(int number) {
        this.number = number;
        this.nodes = new HashSet<>();
    }

    public boolean contains(Node node) {
        return nodes.contains(node);
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    // Getters
    public int getNumber() {
        return number;
    }

    public Set<Node> getNodes() {
        return nodes;
    }
}
