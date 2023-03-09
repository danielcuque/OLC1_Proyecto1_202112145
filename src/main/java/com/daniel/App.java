package com.daniel;

import com.daniel.controller.Conjuntos.Conjunto;
import com.daniel.model.ManageFile;
import com.daniel.model.ReportGraphviz;

import java.io.StringReader;


public class App {
    public static void main(String[] args) {
        
        //MainMenu mainMenu = new MainMenu();
        //mainMenu.setVisible(true);
        String path = "src/examples/test1.olc";
        try {
            //ReportHTML report = new ReportHTML();
            String lines = ManageFile.ReadFiles(path);
            ExreganLexer lexer = new ExreganLexer(new StringReader(lines));
            parser p = new parser(lexer);
            p.parse();

            ReportGraphviz report = new ReportGraphviz();

            for(Conjunto conjunto : p.Conjuntos){
                System.out.println(conjunto.toString());
            }
        }catch (java.lang.Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        /*
        //ArrayList<ExceptionReport> errors = new ArrayList();


        */



    }
}
