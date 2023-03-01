package com.daniel.controller;

public class ExceptionReport {
    public String type;
    public String description;
    public String line;
    public String col;

    public ExceptionReport(String type, String description, String line, String col) {
        this.type = type;
        this.description = description;
        this.line = line;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Error{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", line='" + line + '\'' +
                ", col='" + col + '\'' +
                '}';
    }
}
