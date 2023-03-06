package com.daniel.controller.Tree;

import java.util.HashSet;

public class Tree {

    public Node Root;
    public String NameRegex;

    public Tree(Node body, String nameRegex, int operatorNodeCounter, int nodeCounter){
        NameRegex = nameRegex;
        this.Root = new Node(".", NodeType.AND, 0);
        this.Root.left = body;
        this.Root.right = new Node("#", NodeType.ACCEPT, nodeCounter + 1);
    }


    public void calculateTreeAttr(Node root){
        if (root == null) {
            return;
        }
        // Recursive call
        switch (root.type){
            // Calculate follow for star
            case STAR -> {

                root.nullable = true;
                calculateTreeAttr(root.left);
                root.first = new HashSet<>(root.left.first);
                root.last = new HashSet<>(root.left.last);
            }
            case PLUS -> {
                calculateTreeAttr(root.left);
                root.nullable = root.left.nullable;
                root.first = new HashSet<>(root.left.first);
                root.last = new HashSet<>(root.left.last);
            }
            case OR -> {
                calculateTreeAttr(root.left);
                calculateTreeAttr(root.right);
                root.nullable = root.left.nullable || root.right.nullable;
                root.first = new HashSet<>(root.left.first);
                root.first.addAll(root.right.first);
                root.last = new HashSet<>(root.left.last);
                root.last.addAll(root.right.last);

            }
            case AND -> {
                calculateTreeAttr(root.left);
                calculateTreeAttr(root.right);
                root.nullable = root.left.nullable && root.right.nullable;
                if (root.left.nullable) {
                    root.first = new HashSet<>(root.left.first);
                    root.first.addAll(root.right.first);
                } else {
                    root.first = new HashSet<>(root.left.first);
                }
                if (root.right.nullable) {
                    root.last = new HashSet<>(root.left.last);
                    root.last.addAll(root.right.last);
                } else {
                    root.last = new HashSet<>(root.right.last);
                }
            }
            case LEAVE, ACCEPT -> {
                root.nullable = false;
                root.first = new HashSet<>();
                root.first.add(root.number);
                root.last = new HashSet<>();
                root.last.add(root.number);
            }
        }
    }

    public void calculateFollow(Node root){

    }
}
