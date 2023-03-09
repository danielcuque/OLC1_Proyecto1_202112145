package com.daniel.controller.Conjuntos;

import java.util.HashSet;
import java.util.Set;

public class Conjunto {

    public String identifier;
    public String type;
    public Set<String> elements = new HashSet<>();

    public Conjunto(String identifier){
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }

}
