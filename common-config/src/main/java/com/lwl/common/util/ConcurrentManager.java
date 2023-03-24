package com.lwl.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ConcurrentManager {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>(List.of("Bhavana", "Asha", "Naresh", "Lakshman", "Murali"));

    ListIterator<String> iterator = list.listIterator();
    while(iterator.hasNext()){
      String name = iterator.next();
      if (name.equals("Naresh")) {
         iterator.add("Lakshman A");
      }
    }
    System.out.println(list);

  }
}
