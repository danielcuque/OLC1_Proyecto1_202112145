package com.daniel.controller.FollowTable;

import com.daniel.controller.Tree.Node;

import java.util.*;

public class FollowTable {
    private final Set<Node> tableRows;

    public FollowTable() {
        Comparator<Node> comparator = Comparator.comparingInt(Node::getNumber);
        tableRows = new TreeSet<>(comparator);
    }

    public void addTableRow(Node node) {
        tableRows.add(node);
    }

    public Set<Node> getTableRows() {
        return tableRows;
    }


    public Node getNode(int number) {
        for (Node node : tableRows) {
            if (node.getNumber() == number) {
                return node;
            }
        }
        return null;
    }
}