package com.lwl.sc.di.pms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@ComponentScan("com.lwl.sc.di.pms")
public class Manager {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);
    TransactionService service = context.getBean(TransactionService.class);
    service.uploadTransactionDetails(new File("dummy_statement.pdf"));
  }
}
