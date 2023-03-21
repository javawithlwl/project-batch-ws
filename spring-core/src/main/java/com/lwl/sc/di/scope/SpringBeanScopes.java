package com.lwl.sc.di.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.lwl.sc.di.scope")
public class SpringBeanScopes {

  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanScopes.class);
    GreetingService obj1 = context.getBean(GreetingService.class);
    GreetingService obj2 = context.getBean(GreetingService.class);
    GreetingService obj3 = context.getBean(GreetingService.class);
    System.out.println(obj1);
    System.out.println(obj2);
    System.out.println(obj3);
    ApplicationContext context1 = new AnnotationConfigApplicationContext(SpringBeanScopes.class);
    GreetingService obj4 = context1.getBean(GreetingService.class);
    GreetingService obj5 = context1.getBean(GreetingService.class);
    GreetingService obj6 = context1.getBean(GreetingService.class);
    System.out.println(obj4);
    System.out.println(obj5);
    System.out.println(obj6);

  }
}
