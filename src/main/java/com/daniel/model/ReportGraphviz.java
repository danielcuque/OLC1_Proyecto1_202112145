package com.daniel.model;

import com.daniel.controller.Tree.Node;
import com.daniel.controller.Tree.NodeType;

import java.util.stream.Collectors;

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
            case LEAVE, ACCEPT -> String.format("%s%d [label=\"Lexema:%s\\nAnulable:%s\\nFirstPos:%s\\nLastPos:%s\\nId:%d\"];\n", root.type, root.number, label, nullLabel, firstPos, lastPos, root.number);
            case AND, OR -> String.format("%s%d [label=\"%s\\nAnulable:%s\\nFirstPos:%s\\nLastPos:%s\"];\n%s%d ->%s%d;\n%s%d ->%s%d;\n",
                    root.type, root.number, label, nullLabel, firstPos, lastPos, root.type, root.number, root.left.type, root.left.number,
                    root.type, root.number, root.right.type, root.right.number);
            case STAR, PLUS, QUERY -> String.format("%s%d [label=\"%s\\nAnulable:%s\\nFirstPos:%s\\nLastPos:%s\"];\n%s%d ->%s%d;\n",
                    root.type, root.number, label,nullLabel, firstPos, lastPos, root.type, root.number, root.left.type, root.left.number);
            default -> "";
        };
        sb.append(typeLabel);
        sb.append(generateTreeGraph(root.left, nameRegex));
        sb.append(generateTreeGraph(root.right, nameRegex));
        return sb.toString();
    }

    public String generateFollowTable(Node root, String nameRegex) {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph ").append(nameRegex).append(" {\n");
        sb.append("    node [shape=plaintext]\n");
        sb.append("    rankdir=TB\n");
        sb.append("    label = \"").append(nameRegex).append("\";\n");
        sb.append("    A [label=<\n");
        sb.append(generateBodyTable(root));
        sb.append("    >];\n");
        sb.append("}");
        return sb.toString();
    }

    public String generateBodyTable(Node root) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\" cellborder=\"1\" cellspacing=\"0\">\n");
        sb.append("<tr><td>Lexema</td><td>Número de Id</td><td>Siguientes</td></tr>\n");
        sb.append(generateRowTable(root));
        sb.append("</table>\n");
        return sb.toString();
    }

    public String generateRowTable(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(generateRowTable(root.left));
        if (root.type == NodeType.LEAVE || root.type == NodeType.ACCEPT) {
            // Lexema | Id | FollowPos
            String followPos = root.type == NodeType.LEAVE ? root.getFollowPosString() : "-";
            sb.append(String.format("<tr><td>%s</td><td>%d</td><td>%s</td></tr>\n", root.lexeme, root.number, followPos));
        }
        sb.append(generateRowTable(root.right));
        return sb.toString();
    }

}
