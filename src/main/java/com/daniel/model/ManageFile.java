package com.daniel.model;

import java.io.*;


public class ManageFile {

    public static void generateGraphvizFile(String path, String content){
        File dot;

        try {
            dot = new File(path + ".dot");
            FileWriter fw = new FileWriter(dot);
            fw.write(content);
            fw.close();
            String[] command = {"dot", "-Tpng", dot.getAbsolutePath(), "-o", path + ".png"};
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            process.waitFor();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void WriteFiles(String path, String content) {
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter pw;

        try {
            f = new File(path);
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            pw = new PrintWriter(bw);
            pw.write(content);
            pw.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
