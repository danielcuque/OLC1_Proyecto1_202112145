package com.daniel.controller;

public class Node {
    private String name;
    private String value;
    private Node left;
    private Node right;

    public Node(String name, String value) {
        this.name = name;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(String name, String value, Node left, Node right) {
        this.name = name;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
