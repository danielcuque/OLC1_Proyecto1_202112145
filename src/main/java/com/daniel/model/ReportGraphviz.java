package com.daniel.model;

import com.daniel.controller.Tree.Node;

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

    public String generateTreeGraph(Node root, String nameRegex) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        if (root.number == 0) {
            sb.append(String.format("digraph %s {\n", nameRegex));
            sb.append(String.format("root%d [label=\"%s%s\"];\n", root.number, root.lexeme, root.nullable ? "V" : "F"));
            sb.append(String.format("root%d ->%s%d;\n", root.number, root.left.type, root.left.number));
            sb.append(String.format("root%d ->%s%d;\n", root.number, root.right.type, root.right.number));

            sb.append(generateTreeGraph(root.left, nameRegex));
            sb.append(generateTreeGraph(root.right, nameRegex));
            sb.append("}");
            return sb.toString();
        }

        String label = root.lexeme.toString();
        String nullLabel = root.nullable ? "V" : "F";
        String typeLabel = switch (root.type) {
            case LEAVE, ACCEPT -> String.format("%s%d [label=\"%s%s\"];\n", root.type, root.number, label, nullLabel);
            case AND, OR -> String.format("%s%d [label=\"%s%s\"];\n%s%d ->%s%d;\n%s%d ->%s%d;\n",
                    root.type, root.number, label, nullLabel ,root.type, root.number, root.left.type, root.left.number,
                    root.type, root.number, root.right.type, root.right.number);
            case STAR, PLUS -> String.format("%s%d [label=\"%s%s\"];\n%s%d ->%s%d;\n",
                    root.type, root.number, label,nullLabel, root.type, root.number, root.left.type, root.left.number);
            default -> "";
        };
        sb.append(typeLabel);
        sb.append(generateTreeGraph(root.left, nameRegex));
        sb.append(generateTreeGraph(root.right, nameRegex));
        return sb.toString();
    }
}
