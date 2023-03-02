package com.daniel;

import com.daniel.controller.ExceptionReport;
import com.daniel.model.ManageFile;
import com.daniel.model.ReportHTML;
import java_cup.runtime.Symbol;

import java.io.StringReader;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        String path = "src/examples/test.olc";
        ArrayList<ExceptionReport> errors = new ArrayList();

        try {
            ReportHTML report = new ReportHTML();
            String lines = ManageFile.ReadFiles(path);
            ExreganLexer lexer = new ExreganLexer(new StringReader(lines));
            parser p = new parser(lexer);
            Symbol s = p.parse();

            //errors.addAll(lexer.errors);
            //errors.addAll(p.getErrores());

            //if (errors.size() > 0) {
            /*    report.htmlReport(errors, "src/reports/ERRORES_202112145/Reporte-de-ejecucion.html");
            } else {
                System.out.println("No errors found");
            }*/
        }catch (java.lang.Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
}
