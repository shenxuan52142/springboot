package com.shenxuan.springboot.IO.Use;

import java.io.*;

public class FileOutputShortcut {
    static String file = "C:\\shenxuan\\ceshi1.out";

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new StringReader(
                BufferedInputFile.read("C:\\Users\\Administrator\\IdeaProjects\\springboot\\src\\main\\java\\com\\shenxuan\\springboot\\IO\\Use\\BasicFileoutput.java")
        ));


        PrintWriter out = new PrintWriter(file);

        int linecount = 1;
        String s;
        while ((s=in.readLine())!=null){
            out.println(linecount++ +": "+s);

        }
        out.close();
        System.out.println(BufferedInputFile.read(file));

    }
}
