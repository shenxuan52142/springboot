package com.shenxuan.springboot.IO.Channels;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannels {
    private static final int BSIZE = 1024;

    public static void main(String[] args)throws Exception {
        FileChannel fc = new FileOutputStream("C:\\shenxuan\\ceshi.out").getChannel();
        fc.write(ByteBuffer.wrap("ceshhisdasdasdas".getBytes()));
        fc.close();
    }
}
