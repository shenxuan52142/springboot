package com.shenxuan.springboot.aop;

public class ForumServiceImpl implements ForumService {
    @Override
    public void removeToplic(int topicId) {
        System.out.println("模拟删除Topic记录："+topicId);
        try{
            Thread.currentThread().sleep(20);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeFourm(int forum) {
        System.out.println("模拟删除Forum记录："+forum);
        try{
            Thread.currentThread().sleep(40);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
