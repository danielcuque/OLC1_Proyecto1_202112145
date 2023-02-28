package com.daniel;

import com.daniel.model.ManageFile;
import java_cup.runtime.Symbol;

import java.io.StringReader;


public class App {
    public static void main(String[] args) {
        String path = "src/examples/test.olc";

        try {
            String lines = ManageFile.ReadFiles(path);
            ExreganLexer lexer = new ExreganLexer(new StringReader(lines));
            parser p = new parser(lexer);
            Symbol s = p.parse();
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
}
