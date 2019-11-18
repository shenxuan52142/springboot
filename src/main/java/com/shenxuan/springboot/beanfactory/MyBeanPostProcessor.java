package com.shenxuan.springboot.beanfactory;

import com.shenxuan.springboot.bean.FeedBackVo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName)
//            throws BeansException {
//        if (beanName.equals("feedbackvo")){
//            FeedBackVo feedBackVo = (FeedBackVo) bean;
//            if (feedBackVo.getSex()==null){
//                System.out.println("调用BeanPostProcessor.postProcess" +
//                        "BeforeInitialization()," +
//                        "Sex为空，设置为默认女");
//                feedBackVo.setSex("女");
//            }
//        }
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName)
//            throws BeansException {
//        if (beanName.equals("feedbackvo")){
//            FeedBackVo feedBackVo=(FeedBackVo) bean;
//            if (feedBackVo.getAge()>=16){
//                System.out.println("调用BeanPostProcessor.postProcess" +
//                        "AfterInitialization()," +
//                        "将年龄设置为16");
//                feedBackVo.setAge(16);
//            }
//        }
//        return bean;
//    }
}
