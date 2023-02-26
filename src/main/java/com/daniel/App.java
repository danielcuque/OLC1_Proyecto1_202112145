package com.daniel;

import com.daniel.model.ManageFile;
import java_cup.runtime.Symbol;

import java.io.StringReader;


public class App {
    public static void main(String[] args) {
        String path = "src/examples/Archivo_de_prueba.olc";

        try {
            String lines = ManageFile.ReadFiles(path);
            ExreganLexer lexer = new ExreganLexer(new StringReader(lines));

            while (true){
                Symbol token = lexer.next_token();
                if (token.sym == 0){
                    break;
                }
                System.out.println(token.value + " " + token.sym);
            }
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
}
