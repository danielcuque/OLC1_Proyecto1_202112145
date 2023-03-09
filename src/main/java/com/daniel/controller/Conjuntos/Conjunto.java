package com.daniel.controller.Conjuntos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Conjunto {

    public String identifier;
    public String type;
    public ArrayList<String> elements = new ArrayList<>();

    public Conjunto(String identifier){
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }

    public boolean contains(String character){
        // Si es un tipo rango, crear una expresión regular que lo represente y evaluarla

        if (type.equals("RANGE")){
            String start = this.elements.get(0);
            String end = this.elements.get(1);
            return character.compareTo(start) >= 0 && character.compareTo(end) <= 0;
        }
        Set<String> elements = new HashSet<>(this.elements);
        return elements.contains(character);
    }
}
