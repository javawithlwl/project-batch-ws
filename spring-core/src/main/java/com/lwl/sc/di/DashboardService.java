package com.lwl.sc.di;

public class DashboardService {

  private GreetingService greetingService;

  public void showGreetings() {
    String message = greetingService.greetings();
    System.out.println(message);
  }

  public GreetingService getGreetingService() {
    return greetingService;
  }

  public void setGreetingService(GreetingService greetingService) {
    this.greetingService = greetingService;
  }
}
