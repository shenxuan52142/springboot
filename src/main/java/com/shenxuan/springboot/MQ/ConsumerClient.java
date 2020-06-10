package com.shenxuan.springboot.MQ;

public class ConsumerClient {
    public static void main(String[] args) throws Exception{
        MqClient client = new MqClient();
        String message = client.consume();
        System.out.println("获取到的消息为： "+message);
    }
}
