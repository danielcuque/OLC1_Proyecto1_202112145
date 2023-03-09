package com.daniel;

import com.daniel.controller.Conjunto.Conjunto;
import com.daniel.controller.Errors.ExceptionReport;
import com.daniel.controller.Tree.Node;
import com.daniel.controller.Tree.Tree;
import com.daniel.model.ManageFile;
import com.daniel.model.ReportGraphviz;
import com.daniel.view.MainMenu;

import java.io.StringReader;
import java.util.ArrayList;


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
