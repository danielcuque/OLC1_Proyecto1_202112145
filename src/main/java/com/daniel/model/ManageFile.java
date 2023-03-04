package com.daniel.model;

import java.io.*;


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

    public static void WriteFiles(String path, String content) {

        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter pw;


    }
}
