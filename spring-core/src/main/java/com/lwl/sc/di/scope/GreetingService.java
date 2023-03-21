package com.lwl.sc.di.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${greetings.message:Have a great day}")
    private String message;
    public void showGreetings(){
      System.out.println(message);
    }


}
