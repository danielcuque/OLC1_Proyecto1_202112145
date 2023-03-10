package com.daniel;

import com.daniel.controller.AFND.AFND;
import com.daniel.controller.DFA.DFA;
import com.daniel.controller.Tree.Tree;
import com.daniel.model.ManageFile;
import com.daniel.model.ReportGraphviz;
import java_cup.runtime.Symbol;

import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;


public class App {


    public static void main(String[] args) {
        
        //MainMenu mainMenu = new MainMenu();
        //mainMenu.setVisible(true);

        String path = "src/examples/dificil.olc";
        try {
            //ReportHTML report = new ReportHTML();
            String lines = ManageFile.ReadFiles(path);
            ExreganLexer lexer = new ExreganLexer(new StringReader(lines));
            parser p = new parser(lexer);
            p.parse();
            ReportGraphviz reportGraphviz = new ReportGraphviz();
            for (Tree tree : p.Trees){
                //System.out.println(reportGraphviz.generateTreeGraph(tree.Root, tree.NameRegex));
                //System.out.println(reportGraphviz.generateFollowTable(tree.followTable, tree.NameRegex));
                //System.out.println(reportGraphviz.generateTransitionTable(tree.transitionTable));
                //System.out.println(reportGraphviz.generateAFND(tree.afnd));
                System.out.println(reportGraphviz.generateTransitionTable(tree.transitionTable));
            }


            /*
            for(DFA d : dfa){
                System.out.println(reportGraphviz.generateAFD(d));
            }*/
/*
            for(AFND a : afnd){
                System.out.println(reportGraphviz.generateAFND(a));
            }*/

            //Evaluar cadenas del p.CheckStrings
            //ReportJSON reportJSON = new ReportJSON();
            //String json =  reportJSON.generateStringsEvaluation(dfa, p.CheckStrings);
            //System.out.println(json);

        }catch (java.lang.Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
