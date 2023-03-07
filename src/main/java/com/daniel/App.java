package com.daniel;

import com.daniel.controller.ExceptionReport;
import com.daniel.controller.Tree.Node;
import com.daniel.controller.Tree.Tree;
import com.daniel.model.ManageFile;
import com.daniel.model.ReportGraphviz;

import java.io.StringReader;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        String path = "src/examples/medio.olc";
        ArrayList<ExceptionReport> errors = new ArrayList();

        try {
            //ReportHTML report = new ReportHTML();
            String lines = ManageFile.ReadFiles(path);
            ExreganLexer lexer = new ExreganLexer(new StringReader(lines));
            parser p = new parser(lexer);
            p.parse();

            ReportGraphviz report = new ReportGraphviz();

            for (int i = 0; i < p.Trees.size(); i++) {
                System.out.println("*****Tree *******" + i);
                Tree tree = p.Trees.get(i);
                //Node root = tree.Root;
                //tree.printFollowTable();
                //String treeGraph = report.generateTreeGraph(root, tree.NameRegex);
                //System.out.println(treeGraph);

                String followTableGraph = report.generateFollowTable(tree.followTable, p.Trees.get(i).NameRegex);
                System.out.println(followTableGraph);

            }
        }catch (java.lang.Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
}
