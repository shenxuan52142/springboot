package com.shenxuan.springboot.IO.Use;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFile extends ArrayList<String> {
    public static String read(String fileName){
        StringBuffer sb = new StringBuffer();
        try{
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String s;
           try{
               while ((s=in.readLine())!=null){
               sb.append(s);
               sb.append("\n");
           }

            }finally {
               in.close();
           }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String fileName,String text){
        try{
            PrintWriter out = new PrintWriter(
                    new FileWriter(fileName)
            );
            try{
                out.print(text);
            }finally {
                out.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName,String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
    }
    public static byte[] read(File bFile)throws IOException{
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(bFile)
        );
        try{
            byte[] data = new byte[in.available()];
            in.read(data);
            return data;
        }finally {
            in.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String a = read("C:\\Users\\Administrator\\Desktop\\reportAction.do");
        System.out.println(a);
    }
}
