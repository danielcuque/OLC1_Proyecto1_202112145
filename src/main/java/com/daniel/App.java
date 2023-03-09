package com.daniel;

import com.daniel.controller.CheckStrings.CheckString;
import com.daniel.controller.Conjuntos.Conjunto;
import com.daniel.controller.DFA.DFA;
import com.daniel.controller.Errors.ExceptionReport;
import com.daniel.controller.Tree.Tree;
import com.daniel.model.ManageFile;
import com.daniel.model.ReportGraphviz;
import com.daniel.view.MainMenu;

import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;


public class App {
    public static void main(String[] args) {
        
        //MainMenu mainMenu = new MainMenu();
        //mainMenu.setVisible(true);

        Set<DFA> dfa = new HashSet<>();
        String path = "src/examples/medio.olc";
        try {
            //ReportHTML report = new ReportHTML();
            String lines = ManageFile.ReadFiles(path);
            ExreganLexer lexer = new ExreganLexer(new StringReader(lines));
            parser p = new parser(lexer);
            p.parse();

            ReportGraphviz report = new ReportGraphviz();
            for (Tree tree : p.Trees){
                System.out.println(report.generateAFD(tree.transitionTable));
                dfa.add(new DFA(tree.transitionTable));
            }

            //Evaluar cadenas del p.CheckStrings
            for (CheckString checkString : p.CheckStrings){
                for (DFA dfa1 : dfa){
                    if(dfa1.getName().equals(checkString.name)){
                        System.out.println(dfa1.accept(checkString.string));
                    }
                }
            }

        }catch (java.lang.Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
