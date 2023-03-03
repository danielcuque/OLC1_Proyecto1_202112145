package com.daniel.controller.Tree;

import java.util.Set;

public class Node {
    Set<Integer> first;
    Set<Integer> last;

    boolean nullable;

    Object lexeme;
    NodeType type;
    int number;

    Node left;
    Node right;

    public Node(Object lexeme, NodeType type, int number){
        this.lexeme = lexeme;
        this.type = type;
        this.number = number;
    }

    public Node(Object lexeme, NodeType type, int number, Node left, Node right){
        this.lexeme = lexeme;
        this.type = type;
        this.number = number;
        this.left = left;
        this.right = right;
    }

    public Node(Object lexeme, NodeType type, int number, Node left){
        this.lexeme = lexeme;
        this.type = type;
        this.number = number;
        this.left = left;
    }
}
