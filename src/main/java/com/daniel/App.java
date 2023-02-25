package com.daniel;

import java.io.BufferedReader;
import java.io.StringReader;

public class App {
    public static void main(String[] args) {
        String prueba = "{\n" +
                "CONJ: nuevo -> a~z;\n" +
                "\n" +
                "CONJ: separados -> 2,a,e,R,d,0,9;\n" +
                "CONJ: prueba -> G~O;\n" +
                "CONJ: nuevo1 -> 1~5;\n" +
                "\n" +
                "\n" +
                "EXPreg -> . |{nuevo} \"2\" * {nuevo};\n" +
                "%%\n" +
                "// pruebas \n" +
                "<! comentario multilinea\n" +
                "asdasdasdasd\n" +
                "asdsad!>\n" +
                "EXPreg: \"este es un lexema\";\n" +
                "\n" +
                "}\n";

        ExreganLexer lexer = new ExreganLexer(new StringReader(prueba));

    }
}
