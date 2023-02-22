package com.lwl.capp;

import java.util.ArrayList;
import java.util.List;

public class CollectionExample {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>();
    list.add("Naresh");
    list.add("Murali");
    list.add("Tanvi");
    list.add("Satya");

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    for (String name : list) {
      System.out.println(name);
    }

    list.stream().forEach(ele -> {
      System.out.println(ele);
    });

    list.remove("Satya");
    System.out.println(list.size());
    System.out.println(list.contains("Tanvi"));

    List<String> namesList = new ArrayList<>();
    namesList.add("Aruna");
    namesList.add("Bhavani");
    list.addAll(0,namesList);
    System.out.println(list);
  }
}
