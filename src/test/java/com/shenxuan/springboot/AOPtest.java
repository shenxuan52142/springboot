package com.shenxuan.springboot;

import com.shenxuan.springboot.aop.ForumService;
import com.shenxuan.springboot.aop.ForumServiceImpl;
import com.shenxuan.springboot.aop.PerformanceHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AOPtest {



    @Test
    public void proxy(){
        //希望被代理的目标业务类
        ForumService targe = new ForumServiceImpl();
        //将目标业务类和横切代码编织到一起
        PerformanceHandler handler = new PerformanceHandler(targe);
        //第一个入参 类加载器
        //第二个入参 创建代理实例所需实现的一组接口
        //第三个入参 整合了业务逻辑和横切逻辑的编辑器对象
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                targe.getClass().getClassLoader(),
                targe.getClass().getInterfaces(),
                handler
        );

        proxy.removeFourm(10);
        proxy.removeToplic(1012);
    }
}
