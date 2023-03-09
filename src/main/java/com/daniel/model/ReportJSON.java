package com.daniel.model;

import com.daniel.controller.CheckStrings.CheckString;
import com.daniel.controller.DFA.DFA;

import java.util.ArrayList;
import java.util.Set;

public class ReportJSON {

    public String generateStringsEvaluation(Set<DFA> dfas, ArrayList<CheckString> checkStrings){

        StringBuilder json = new StringBuilder("[");
        for (CheckString checkString : checkStrings){
            for (DFA dfa : dfas){
                if(dfa.getName().equals(checkString.name)){
                    if (checkString.string.contains("'"))
                        checkString.string = checkString.string.replace("'", "\\'");
                    json.append("{ \"Valor\": \"").append(checkString.string).append("\", \"ExpresionRegular\": \"").append(checkString.name).append("\", \"Resultado\": \"").append(dfa.accept(checkString.string) ? "Cadena Válida" : "Cadena Inválida").append("\"},");

                }
            }
        }
        json = new StringBuilder(json.substring(0, json.length() - 1));
        json.append("]");
        return json.toString();
    }
}
