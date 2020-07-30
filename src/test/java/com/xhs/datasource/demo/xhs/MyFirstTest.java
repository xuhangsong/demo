package com.xhs.datasource.demo.xhs;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author xuhan  build  2019/6/20
 */
public class MyFirstTest {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("spring-common.xml");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
		System.out.println(xmlBeanFactory.getBean(MapperScannerConfigurer.class));
	}
}
