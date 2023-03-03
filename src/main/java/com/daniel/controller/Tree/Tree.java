package com.daniel.controller.Tree;

public class Tree {

    Node Root;
    String NameRegex;

    public Tree(Node body, String nameRegex){
        NameRegex = nameRegex;
        this.Root = new Node(".", NodeType.AND, 0);
        
    }
}
