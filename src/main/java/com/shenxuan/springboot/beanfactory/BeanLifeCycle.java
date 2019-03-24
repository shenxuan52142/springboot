package com.shenxuan.springboot.beanfactory;

import com.shenxuan.springboot.bean.FeedBackVo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory(){
        //装载配置文件并启动容器
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory bf = new DefaultListableBeanFactory();
        //启动Spring IOC 容器
        XmlBeanDefinitionReader reader=new
                XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
        reader.loadBeanDefinitions(resource);
        //向容器中注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
        //向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(
                new MyInstantiationAwareBeanPostProcessor());
        //第一次从容器中获取feedbackvo,将触发容器实例化该bean,引发bean生命周期方法的调用
        FeedBackVo feedBackVo1=(FeedBackVo)bf.getBean("feedbackvo");
        feedBackVo1.introduce();
        feedBackVo1.setSex("男");

        //第二次从容器中获取bean,将直接从缓存池中获取
        FeedBackVo feedBackVo2=(FeedBackVo)bf.getBean("feedbackvo");
         feedBackVo2.introduce();
        //查看两个feedbackvo是否指向同一引用
        System.out.println("feedbackvo1==feedbackvo2"+(feedBackVo1==feedBackVo2));

        //关闭容器
        ((DefaultListableBeanFactory)bf).destroySingletons();
    }


    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
