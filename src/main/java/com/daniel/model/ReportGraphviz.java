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
        String label = root.lexeme.toString();
        String nullLabel = root.nullable ? "V" : "F";
        String lastPos = root.getLastPosString();
        String firstPos = root.getFirstPosString();
        String tag = String.format("root%d [label=\"%s\\nAnulable:%s\\nFirstPos:%s\\nLastPos:%s\"];\n", root.number, label, nullLabel, firstPos, lastPos);
        if (root.number == 0) {
            sb.append(String.format("digraph %s {\n", nameRegex));
            sb.append("node [color=\"#FFEDBB\" shape=circle style=filled]\n");
            sb.append("edge [dir=none]\n");
            sb.append(String.format("label = \"%s\";\n", nameRegex));
            sb.append(tag);
            sb.append(String.format("root%d ->%s%d;\n", root.number, root.left.type, root.left.number));
            sb.append(String.format("root%d ->%s%d;\n", root.number, root.right.type, root.right.number));

            sb.append(generateTreeGraph(root.left, nameRegex));
            sb.append(generateTreeGraph(root.right, nameRegex));
            sb.append("}");
            return sb.toString();
        }

        String typeLabel = switch (root.type) {
            case LEAVE, ACCEPT -> String.format("%s%d [label=\"%s\\nAnulable:%s\\nFirstPos:%s\\nLastPos:%s\"];\n", root.type, root.number, label, nullLabel, firstPos, lastPos);
            case AND, OR -> String.format("%s%d [label=\"%s\\nAnulable:%s\\nFirstPos:%s\\nLastPos:%s\"];\n%s%d ->%s%d;\n%s%d ->%s%d;\n",
                    root.type, root.number, label, nullLabel, firstPos, lastPos, root.type, root.number, root.left.type, root.left.number,
                    root.type, root.number, root.right.type, root.right.number);
            case STAR, PLUS -> String.format("%s%d [label=\"%s\\nAnulable:%s\\nFirstPos:%s\\nLastPos:%s\"];\n%s%d ->%s%d;\n",
                    root.type, root.number, label,nullLabel, firstPos, lastPos, root.type, root.number, root.left.type, root.left.number);
            default -> "";
        };
        sb.append(typeLabel);
        sb.append(generateTreeGraph(root.left, nameRegex));
        sb.append(generateTreeGraph(root.right, nameRegex));
        return sb.toString();
    }
}
