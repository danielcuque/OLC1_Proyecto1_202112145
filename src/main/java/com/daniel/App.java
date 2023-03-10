package com.daniel;

import com.daniel.controller.AFND.AFND;
import com.daniel.controller.CheckStrings.CheckString;
import com.daniel.controller.Conjuntos.Conjunto;
import com.daniel.controller.DFA.DFA;
import com.daniel.controller.Errors.ExceptionReport;
import com.daniel.controller.Tree.Node;
import com.daniel.controller.Tree.Tree;
import com.daniel.model.ManageFile;
import com.daniel.model.ReportGraphviz;
import com.daniel.model.ReportJSON;
import com.daniel.view.MainMenu;

import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;


public class App {


    public static void main(String[] args) {
        
        //MainMenu mainMenu = new MainMenu();
        //mainMenu.setVisible(true);

        Set<DFA> dfa = new HashSet<>();
        Set<AFND> afnd = new HashSet<>();
        String path = "src/examples/test1.olc";
        try {
            //ReportHTML report = new ReportHTML();
            String lines = ManageFile.ReadFiles(path);
            ExreganLexer lexer = new ExreganLexer(new StringReader(lines));
            parser p = new parser(lexer);
            p.parse();
            ReportGraphviz reportGraphviz = new ReportGraphviz();
            for (Tree tree : p.Trees){
                dfa.add(new DFA(tree.transitionTable));
                afnd.add(tree.afnd);

            }


            /*
            for(DFA d : dfa){
                System.out.println(reportGraphviz.generateAFD(d));
            }*/

            for(AFND a : afnd){
                System.out.println(reportGraphviz.generateAFND(a));
            }

            //Evaluar cadenas del p.CheckStrings
            //ReportJSON reportJSON = new ReportJSON();
            //String json =  reportJSON.generateStringsEvaluation(dfa, p.CheckStrings);
            //System.out.println(json);

        }catch (java.lang.Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
