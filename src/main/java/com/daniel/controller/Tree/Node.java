package com.daniel.controller.Tree;

import java.util.HashSet;
import java.util.Set;

public class Node {
    public Set<Integer> first;
    public Set<Integer> last;
    public Set<Integer> follow = new HashSet<>();

    public boolean nullable;

    public Object lexeme;
    public NodeType type;
    public int number;

    public Node left;
    public Node right;

    public Node(Object lexeme, NodeType type, int number) {
        this.lexeme = lexeme;
        this.type = type;
        this.number = number;
    }

    public Node(Object lexeme, NodeType type, int number, Node left, Node right) {
        this.lexeme = lexeme;
        this.type = type;
        this.number = number;
        this.left = left;
        this.right = right;
    }

    public Node(Object lexeme, NodeType type, int number, Node left) {
        this.lexeme = lexeme;
        this.type = type;
        this.number = number;
        this.left = left;
    }

    @Override
    public String toString() {
        return this.lexeme.toString();
    }

    public String getFirstPosString() {
        return this.first.toString();
    }

    public String getLastPosString() {
        return this.last.toString();
    }

    public String getFollowPosString() {
        return this.follow.toString();
    }

}
