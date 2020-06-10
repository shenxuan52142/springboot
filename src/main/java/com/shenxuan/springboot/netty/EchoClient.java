package com.shenxuan.springboot.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;

public class EchoClient {
    private final String host;
    private final int port;
    public EchoClient(String host,int port){
        this.host = host;
        this.port = port;
    }
    public void start()throws Exception{
        //设置服务器的InetSocketAddress
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            ChannelFuture f = b.connect().sync();
            f.channel().closeFuture().sync();
            File file = new File("ssss");
            FileInputStream inputStream = new FileInputStream(file);

        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
