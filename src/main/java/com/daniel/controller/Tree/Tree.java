package com.daniel.controller.Tree;

public class Tree {

    public Node Root;
    public String NameRegex;

    public Tree(Node body, String nameRegex, int operatorNodeCounter, int nodeCounter){
        NameRegex = nameRegex;
        this.Root = new Node(".", NodeType.AND, 0);
        this.Root.left = body;
        this.Root.right = new Node("#", NodeType.ACCEPT, nodeCounter + 1);
    }

    public void calculateNullableAndPositions(Node root){
        if (root == null) {
            return;
        }
        // Recursive call
        switch (root.type){
            case STAR -> {
                root.nullable = true;
                calculateNullableAndPositions(root.left);
            }
            case PLUS -> calculateNullableAndPositions(root.left);
            case OR -> {
                calculateNullableAndPositions(root.left);
                calculateNullableAndPositions(root.right);
                root.nullable = root.left.nullable || root.right.nullable;
            }
            case AND -> {
                calculateNullableAndPositions(root.left);
                calculateNullableAndPositions(root.right);
                root.nullable = root.left.nullable && root.right.nullable;
            }
            case LEAVE, ACCEPT -> root.nullable = false;
        }
    }
}
