package com.shenxuan.springboot.IO.Serializable;

import java.io.*;
import java.util.Random;

public class Worm implements Serializable {
    private static Random rand = new Random(47);
    private Data[] d = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private transient String password;
    private Worm next;
    private char c;
    public Worm(int i,char x,String password){
        System.out.println("Worm constructor:"+i);
        c=x;
        this.password = password;
        if (--i>0){
            next = new Worm(i, (char) (x + 1),password);
        }
    }
    public Worm(){
        System.out.println("Default constructor");
    }
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(c)
                .append("(");
        for (Data dat:d){
            stringBuffer.append(dat);
        }
        stringBuffer.append(")");
        if (next!=null){
            stringBuffer.append(next);
        }
        stringBuffer.append(password);
        return stringBuffer.toString();
    }

    public static void main(String[] args)throws Exception {
        Worm w = new Worm(6, 'a',"我是密码");
        System.out.println("w= "+w);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("C:\\shenxuan\\worm.out")
        );
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("C:\\shenxuan\\worm.out")
        );

        String s=(String)in.readObject();
        Worm w2=(Worm)in.readObject();
        System.out.println(s+"w2=  "+w2);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray())
        );
        s = (String) in2.readObject();
        Worm w3 = (Worm) in2.readObject();
        System.out.println(s+"w3 = "+w3);
    }
}
