package com.lwl.sc.di.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan("com.lwl.sc.di.ws")
public class Manager {
  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);
    WalletService service = context.getBean(WalletService.class);
    List<Wallet> list = service.getWallets();
    list.stream().forEach(w->{
      System.out.println(w);
    });
  }
}
