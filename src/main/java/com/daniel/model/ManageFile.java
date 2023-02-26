package com.daniel.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ManageFile {

    public static String ReadFiles(String path) {

        String line;
        String text = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                text += line + "\n";
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return text;

    }
}
