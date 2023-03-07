package com.daniel;

import com.daniel.controller.ExceptionReport;
import com.daniel.model.ManageFile;
import com.daniel.model.ReportGraphviz;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Set;


public class App {
    public static void main(String[] args) {
        String path = "src/examples/test1.olc";
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
                String treeGraph = report.generateTreeGraph(p.Trees.get(i).Root, p.Trees.get(i).NameRegex);
                System.out.println(treeGraph);
                p.Trees.get(i).printFollow(p.Trees.get(i).Root);
                //String followTable = report.generateFollowTable(p.Trees.get(i).Root);
                //System.out.println(followTable);

            }


            // Print trees

            /*
                        while (true){
                Symbol token = lexer.next_token();
                if (token.sym == 0){
                    break;
                }
                System.out.println(token.value + " " + token.sym);
            }

            */



            //Symbol s = p.parse();




            /*
            errors.addAll(lexer.errors);
            errors.addAll(p.getErrores());
            if (errors.size() > 0) {
                report.htmlReport(errors, "src/reports/ERRORES_202112145/Reporte-de-ejecucion1.html");
                System.out.println("Errors found");
            } else {
                System.out.println("No errors found");
            }
            */
        }catch (java.lang.Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
}
