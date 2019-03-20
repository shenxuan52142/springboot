package com.shenxuan.springboot;

import com.shenxuan.springboot.bean.Beans;
import com.shenxuan.springboot.bean.FeedBackVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("wwwww");
	}
	@Test
	public void test10() throws Exception{
		//获取资源文件
		//ResourcePatternResolver接口继承展ResourceLoader接口
		//ResourceLoader可以资源地址加载文件资源
		//PathMatchingResourcePatternResolver实现ResourcePatternResolver
		ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
//		//该路径可以直接写resources下的

		Resource resource=resolver.getResource("classpath:beans.xml");


//		Resource resource = new ClassPathResource("beans.xml");
//		Resource resource = new FileSystemResource("C:/Users/Administrator/IdeaProjects/springboot/target/classes/beans.xml");
//		Resource resource=new PathResource("classpath:beans.xml");
		System.out.println(resource.exists());

		System.out.println(resource.getURL());
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		//通过Resource装载spring配置信息
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		System.out.println("init BeanFactory.");

		FeedBackVo feedbackVO=factory.getBean("feedbackvo", FeedBackVo.class);
		System.out.println(feedbackVO.getAge());
	}
	@Test
    public void test11(){
    }
    @Test
    public void test12(){
	    ApplicationContext context=new AnnotationConfigApplicationContext(Beans.class);
	    FeedBackVo feedBackVo=context.getBean("feedbackvo",FeedBackVo.class);
        System.out.println(feedBackVo.getAge());
    }
}
