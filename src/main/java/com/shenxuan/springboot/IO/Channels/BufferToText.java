package com.shenxuan.springboot.IO.Channels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferToText {
    private static final int BSIZE=1024;

    public static void main(String[] args)throws Exception {
        FileChannel fc = new FileOutputStream("C:\\shenxuan\\ceshi10.out").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new FileInputStream("C:\\shenxuan\\ceshi10.out").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
    }
}
