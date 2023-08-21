package com.mahagan.test;

import com.mahagan.dao.ProjectDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application-context.xml");
        ProjectDao projectDao=applicationContext.getBean("projectDao",ProjectDao.class);
        projectDao.getAllProject();


    }
}