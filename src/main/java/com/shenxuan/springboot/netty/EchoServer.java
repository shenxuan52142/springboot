package com.shenxuan.springboot.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {
    private int port;
    public EchoServer(int port){
        this.port = port;
    }
    public void start() throws Exception{
        //实现业务逻辑
        final EchoServerHandler serverHandler = new EchoServerHandler();
        //使用NioEventLoopGroup来接受和处理新的连接
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    //指定所使用的的NIO传输Channel
                    .channel(NioServerSocketChannel.class)
                    //使用指定的端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    //
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                       @Override
                        public void initChannel(SocketChannel channel)throws Exception{
                           channel.pipeline().addLast(serverHandler);
                       }
                    });
            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
