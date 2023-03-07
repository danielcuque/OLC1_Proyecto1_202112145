package com.daniel.model;

import com.daniel.controller.FollowTable.FollowTable;
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

    public String generateFollowTable(FollowTable followTable, String nameRegex){
        StringBuilder sb = new StringBuilder();
        sb.append("digraph ").append(nameRegex).append(" {\n");
        sb.append("    node [shape=plaintext]\n");
        sb.append("    rankdir=TB\n");
        sb.append("    label = \"").append(nameRegex).append("\";\n");
        sb.append("    A [label=<\n");
        sb.append("        <TABLE BORDER=\"0\" CELLBORDER=\"1\" CELLSPACING=\"0\">\n");
        sb.append("            <TR>\n");
        sb.append("                <TD>Lexema</TD>\n");
        sb.append("                <TD>No. Nodo</TD>\n");
        sb.append("                <TD>Siguientes</TD>\n");
        sb.append("            </TR>\n");
        for (Node node : followTable.getTableRows()) {
            sb.append("            <TR>\n");
            sb.append("                <TD>").append(node.lexeme).append("</TD>\n");
            sb.append("                <TD>").append(node.number).append("</TD>\n");
            sb.append("                <TD>").append(node.getFollowPosString()).append("</TD>\n");
            sb.append("            </TR>\n");
        }
        sb.append("        </TABLE>\n");
        sb.append("    >]\n");
        sb.append("}");
        return sb.toString();
    }

}
