package com.shenxuan.springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("prototype")
@Component
public class FeedBackVo implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
    private String name,sex;
    private int age;

    private BeanFactory beanFactory;
    private String beanName;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public FeedBackVo(){
        System.out.println("调用FeedBackVo()的构造函数。");
    }
    public FeedBackVo(String name,String sex,int age){
        this.name=name;
        this.sex=sex;
        this.age=age;
    }
    public void setName(String name){
        System.out.println("调用setName()设置属性。");
        this.name=name;
    }
    public void introduce(){
        System.out.println("age:"+age+";name:"+name+";sex:"+sex);
    }


    //BeanfactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanfactory()方法");
        this.beanFactory=beanFactory;
    }
    //BeanfactoryAware接口方法
    @Override
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware.setBeanName()方法");
        this.beanName=beanName;
    }
    //DisposableBean接口中的方法
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy()方法");
    }
    //InitializingBean中的方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet()方法");
    }
    //通过<bean>的init-method属性指定的初始化方法
    public void myInit(){
        System.out.println("调用init-method所指定的myInit().将age设为28");
        this.age = 28;
    }
    //通过<bean>的destroy-method属性指定的销毁方法
    public void myDestroy(){
        System.out.println("调用destroy-method所指定的myDestroy()");
    }
}
