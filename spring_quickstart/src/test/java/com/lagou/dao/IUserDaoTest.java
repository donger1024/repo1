package com.lagou.dao;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class IUserDaoTest {

    @Test
    public void save1() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //ApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("D:\\idea源代码\\lagou_spring\\spring_quickstart\\src\\main\\resources\\applicationContext.xml");

        //IUserDao userDao = (IUserDao) fileSystemXmlApplicationContext.getBean("userDao");

        IUserDao userDao = applicationContext.getBean("userDao2",IUserDao.class);

        userDao.save();

    }

    @Test
    public void save2(){
        BeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

        IUserDao userDao = (IUserDao) xmlBeanFactory.getBean("userDao");

        userDao.save();
    }
}