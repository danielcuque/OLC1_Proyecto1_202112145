package com.daniel.controller.Tree;


import java.util.HashSet;

public class Tree {

    public Node Root;
    public String NameRegex;


    public Tree(Node body, String nameRegex, int operatorNodeCounter, int nodeCounter) {
        NameRegex = nameRegex;
        this.Root = new Node(".", NodeType.AND, 0);
        this.Root.left = body;
        this.Root.right = new Node("#", NodeType.ACCEPT, nodeCounter + 1);
        calculateTreeAttr(this.Root);
        calculateFollow(this.Root);
    }

    public void calculateTreeAttr(Node root) {
        if (root == null) {
            return;
        }
        // Recursive call
        switch (root.type) {
            // Calculate * ?
            case STAR -> {

                root.nullable = true;
                calculateTreeAttr(root.left);
                root.first = new HashSet<>(root.left.first);
                root.last = new HashSet<>(root.left.last);
            }
            case PLUS, QUERY -> {
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

    public void calculateFollow(Node root) {
        if (root == null) {
            return;
        }

        // Calculate follow
        switch (root.type) {
            case STAR, PLUS -> {
                for (Integer i: root.last){
                    Node node = findNode(root, i);
                    node.follow.addAll(root.first);
                    calculateFollow(root.left);
                }

            }
            case AND -> {
                for (Integer i: root.left.last){
                    Node node = findNode(root, i);
                    node.follow.addAll(root.right.first);
                    calculateFollow(root.left);
                    calculateFollow(root.right);
                }
            } case OR -> {
                calculateFollow(root.left);
                calculateFollow(root.right);
            }
        }
    }

    private Node findNode(Node root, int number) {
        if (root == null) {
            return null;
        }
        if (root.number == number && (root.type == NodeType.LEAVE || root.type == NodeType.ACCEPT)) {
            return root;
        }
        Node left = findNode(root.left, number);
        if (left != null) {
            return left;
        }
        return findNode(root.right, number);
    }

    public void printFollow(Node root) {
        if (root == null) {
            return;
        }
        printFollow(root.left);
        if (root.type == NodeType.LEAVE) {
            System.out.println(root.lexeme + " " + root.getFollowPosString());
        }
        printFollow(root.right);
    }
}
