package com.lwl.sc.di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@ComponentScan("com.lwl.sc.di.xml")
public class Manager {

  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);
    ContactController contactController = context.getBean(ContactController.class);
    List<Contact> list = contactController.getContacts();
    list.stream().forEach(ele->{
      System.out.println(ele);
    });
  }
}
