package com.shenxuan.springboot.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends
        InstantiationAwareBeanPostProcessorAdapter {
    //在实例化bean前调用
    public Object postProcessBeforeInstantiation(Class beanClass,String beanName)
                     throws BeansException{
        //仅对容器中的 feedbackvo bean进行处理
       if ("feedbackvo".equals(beanName)){
           System.out.println("InstantiationAware BeanPostProcessor.postProcess" +
                   "BeforeInsantiation");
       }
       return null;
    }

    //接口方法 在实例化bean后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName)
            throws BeansException {
        //仅对容器中的 feedbackvo bean进行处理
        if ("feedbackvo".equals(beanName)){
            System.out.println("InstantiationAware BeanPostProcessor.postProcess" +
                    "AfterInsantiation");
        }
        return true;
    }

    //接口方法，在设置某个属性时调用

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        //仅对容器中的 feedbackvo bean进行处理
        if ("feedbackvo".equals(beanName)){
            System.out.println("InstantiationAware BeanPostProcessor.postProcess" +
                    "PropertyValues");
        }
        return pvs;
    }
}
