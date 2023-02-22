package com.lwl.capp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayListExample {

  public static void main(String[] args) {
    List<String> cricket = List.of("Bhavani","Tanvi","Dhatri","Naresh");
    List<String> football = List.of("Bhavani","Tanvi","Joythi","Nagamani");
    List<String> badminton = List.of("Bhavani","Tanvi","Dhatri","Naresh","Suresh","Rajesh");
    // Get all the player name
    Set<String> nameList = new HashSet<>();
    nameList.addAll(cricket);
    nameList.addAll(badminton);
    nameList.addAll(football);
    System.out.println(nameList);
  }
}
