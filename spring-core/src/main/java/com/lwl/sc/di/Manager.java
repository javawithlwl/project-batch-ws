package com.lwl.sc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Manager {

  public static void main(String[] args) {

    ApplicationContext context = new ClassPathXmlApplicationContext("greetings-bean.xml");
    DashboardService service = context.getBean(DashboardService.class);
    service.showGreetings();

  }
}
