package com.shenxuan.springboot.MQ;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {
    //x消息队列储存消息的最大数量
    private final static int MAX_SIZE = 3;

    //保存消息的容器
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);

    //生产消息
    public static void offer(String msg){
        if (messageQueue.offer(msg)){
            System.out.println("成功向消息中心投递消息“：" + msg + " ,当前消息中心暂存的消息数量为： " + messageQueue.size());
        }else {
            System.out.println("消息中心已满！");
        }
    }

    //消费消息
    public static String consume(){
        //返回队列头部的消息，并且删除
        String msg = messageQueue.poll();
        if (msg!=null){
            System.out.println("已经消费信息： " + msg + " ,目前还有的消息数量为： " + messageQueue.size());
        }else {
            System.out.println("没有消息了");
        }
        System.out.println("============================");
        return msg;
    }
}
