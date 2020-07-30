package com.xhs.datasource.demo;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author xuhan  build  2019/6/28
 */
public class SpringStart {
    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("spring-common.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        System.out.println(xmlBeanFactory.getBean("user"));
        System.out.println(xmlBeanFactory.getBean("user2"));
        System.out.println(xmlBeanFactory.getBean("user3"));
    }
}
