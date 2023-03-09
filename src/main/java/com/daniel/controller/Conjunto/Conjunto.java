package com.daniel.controller.Conjunto;

import java.util.HashSet;
import java.util.Set;

public class Conjunto {

    private String identifier;
    public String type;
    public Set<String> elements = new HashSet<>();

    public Conjunto(String identifier){
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "Conjunto{" +
                "identifier='" + identifier + '\'' +
                ", type='" + type + '\'' +
                ", elements=" + elements +
                '}';
    }

}
