package com.shenxuan.springboot.MQ.rabbitMq;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args)throws Exception {
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
        final Channel channel = conn.createChannel();
        //声明交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);
        //声明队列
        String queneName = channel.queueDeclare().getQueue();
        String routingKey = "testRoutingKey";
        //绑定队列，通过路由键 testRoutingKey 将队列和交换器绑定起来
        channel.queueBind(queneName, exchangeName, routingKey);

        while (true){
            //消费消息
            boolean autoAck = false;
            String consmerTag = "";
            channel.basicConsume(queneName, autoAck, consmerTag, new DefaultConsumer(channel){
               @Override
               public void handleDelivery(String consumerTag, Envelope envelope,AMQP.BasicProperties properties
               ,byte[] body) throws IOException {
                   String routingKey = envelope.getRoutingKey();
               }
            });
        }
    }
}
