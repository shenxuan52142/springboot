package com.shenxuan.springboot;

import com.shenxuan.springboot.bean.FeedBackVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.test.context.junit4.SpringRunner;

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
		//PathMatchingResourcePatternResolver实现
		ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		Resource res=resolver.getResource("classpath:beans.xml");

		System.out.println(res.getURL());
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(res);
		System.out.println("init BeanFactory.");

		FeedBackVo feedbackVO=factory.getBean("feedbackVo1", FeedBackVo.class);
		System.out.println(feedbackVO.getAge());
	}


}
