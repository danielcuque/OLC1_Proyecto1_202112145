package com.daniel.model;

import com.daniel.controller.Tree.Node;
import com.daniel.controller.Tree.NodeType;

public class ReportGraphviz {

    /*
    TODO:
     -Implement method to display graphviz report
     - Implement method to save graphviz report
     - Implement method to save graphviz report as image
     - Implement method to save graphviz report as pdf
     - Implement method to execute dot command
    */

    public void generateGraphvizReport(String path, String content) {
        ManageFile mf = new ManageFile();
        mf.WriteFiles(path, content);
    }

    public String generateTreeGraph(Node root, String nameRegex){
        String graph = "";
        if (root == null) {
            return "";
        }
        if (root.number == 0){
            graph += "digraph "+ nameRegex +"{\n";
            graph += "root" + root.number + "[label=\"" + root.lexeme + "\"];\n";
            graph += "root" + root.number + " ->"+root.left.type + root.left.number + ";\n";
            graph += "root" + root.number + " ->"+root.right.type + root.right.number + ";\n";

            graph += generateTreeGraph(root.left, nameRegex);
            graph += generateTreeGraph(root.right, nameRegex);
            graph += "}";
            return graph;
        }
        switch (root.type) {
            case LEAVE, ACCEPT -> {
                graph +=root.type + "" + root.number + "[label=\"" + root.lexeme + "\"];\n";
            }
            case AND, OR -> {
                graph += root.type + "" + root.number + " [label=\"" + root.lexeme + "\"];\n";
                graph += root.type + "" + root.number + " ->" + root.left.type + root.left.number + ";\n";
                graph += root.type + "" + root.number + " ->" + root.right.type + root.right.number + ";\n";
                graph += generateTreeGraph(root.left, nameRegex);
                graph += generateTreeGraph(root.right, nameRegex);
            }
            case STAR -> {
                graph += root.type + "" + root.number + " [label=\"" + root.lexeme + "\"];\n";
                graph += root.type + "" + root.number + " ->" + root.left.type + root.left.number + ";\n";
                graph += generateTreeGraph(root.left, nameRegex);
            }
        }
        return graph;
    }

}
