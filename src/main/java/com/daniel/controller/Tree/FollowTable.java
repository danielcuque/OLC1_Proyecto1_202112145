package com.daniel.controller.Tree;


import java.util.*;

public class FollowTable {
    private Set<Node> tableRows;

    public FollowTable() {
        Comparator<Node> comparator = Comparator.comparingInt(Node::getNumber);
        tableRows = new TreeSet<>(comparator);
    }

    public void addTableRow(Node node) {
        // Insertar de forma ordenada descendente por el numero de nodo
        // tableRows.add(node);
        tableRows.add(node);
    }

    public void printFollowTable() {
        System.out.println("Follow Table");
        System.out.println("------------");
        for (Node node : tableRows) {
            System.out.println("Lexeme -> "+ node.lexeme + ", Node ->  " + node.number + ", Follows -> " + node.getFollowPosString());
        }
    }
}