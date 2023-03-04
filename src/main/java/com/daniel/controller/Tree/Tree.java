package com.daniel.controller.Tree;

public class Tree {

    public Node Root;
    String NameRegex;

    public Tree(Node body, String nameRegex, int operatorNodeCounter, int nodeCounter){
        NameRegex = nameRegex;
        this.Root = new Node(".", NodeType.AND, 0);
        this.Root.left = body;
        this.Root.right = new Node("#", NodeType.ACCEPT, nodeCounter + 1);
    }

    public void traverseLeft(Node root) {

        if (root == null) {
            return;
        }

        traverseLeft(root.left);
        System.out.println(root.lexeme + " " + root.type + " " + root.number);
        traverseLeft(root.right);
    }

}
