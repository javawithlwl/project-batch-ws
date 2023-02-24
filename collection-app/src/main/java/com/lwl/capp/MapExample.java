package com.lwl.capp;
import org.apache.commons.collections4.MapUtils;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapExample {
  public static void main(String[] args) {
    List<String> names = List.of("Krish", "Manoj", "Charan", "Kiran", "Jayesh", "Ramesh", "Lakshmi Narayana");
    Map<String, Integer> map = names.stream().collect(Collectors.toMap(ele->ele,ele->ele.length()));
    if(MapUtils.isNotEmpty(map)){
      System.out.println(map);
    }
  }

}
