package com.lwl.sc.di.scope;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
class LwlFileReader {

  @PreDestroy
  public void close() throws Exception {
    System.out.println("Destroy");
  }

  @PostConstruct
  public void init() throws Exception {
    System.out.println("Init");
  }
}
@ComponentScan("com.lwl.sc.di.scope")
public class CallbackExample {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(CallbackExample.class);
    context.close();
  }
}
