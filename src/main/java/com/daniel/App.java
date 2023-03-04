package com.daniel;

import com.daniel.controller.ExceptionReport;
import com.daniel.model.ManageFile;
import com.daniel.model.ReportHTML;

import java.io.StringReader;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        String path = "src/examples/test1.olc";
        //ArrayList<ExceptionReport> errors = new ArrayList();

        try {
            //ReportHTML report = new ReportHTML();
            String lines = ManageFile.ReadFiles(path);
            ExreganLexer lexer = new ExreganLexer(new StringReader(lines));
            parser p = new parser(lexer);
            p.parse();

            // Print trees
            for (int i = 0; i < p.Trees.size(); i++) {
                System.out.println("*****Tree *******" + i);
                p.Trees.get(i).traverseLeft(p.Trees.get(i).Root);
            }

            /*
            while (true){
                Symbol token = lexer.next_token();
                if (token.sym == 0){
                    break;
                }
                System.out.println(token.value + " " + token.sym);
            }
            //Symbol s = p.parse();


            //errors.addAll(lexer.errors);
            //errors.addAll(p.getErrores());

            //if (errors.size() > 0) {
            report.htmlReport(errors, "src/reports/ERRORES_202112145/Reporte-de-ejecucion.html");
            } else {
                System.out.println("No errors found");
            }*/
        }catch (java.lang.Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
}
