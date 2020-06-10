package com.shenxuan.springboot.MQ.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    public static void main(String[] args) throws Exception {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        //设置地址
        factory.setHost("localhost");
        factory.setVirtualHost("/");
        //建立到代理服务器的连接--socket
        Connection conn = factory.newConnection();
        //创建信道--建立在TCP之上的虚拟连接 可以防止TCP的反复打开和关闭
        Channel channel = conn.createChannel();
        //声明交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);

        String routingKey = "testRoutingKey";

        //发布消息
        byte[] messaheBodyBytes = "quit".getBytes();
        channel.basicPublish(exchangeName,routingKey,null,messaheBodyBytes);
        //关闭信道
        channel.close();
        conn.close();
    }
}
