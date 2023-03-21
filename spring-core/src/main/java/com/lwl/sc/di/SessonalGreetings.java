package com.lwl.sc.di;

public class SessonalGreetings implements  GreetingService {

    private String message;

  @Override
  public String greetings() {
    return message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
