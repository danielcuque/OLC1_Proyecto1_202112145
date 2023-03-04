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
}
