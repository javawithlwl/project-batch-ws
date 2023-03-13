package com.lwl.iplstats.dao;

public class NumberOperations {


  public int biggest(int a, int b, int c) {
//        if(a > b && a > c){
//          return a;
//        }else if(b > c){
//          return b;
//        }else{
//          return c;
//        }
    return a > b && a > c ? a : b > c ? b : c;
  }

  public float division(int a, int b) {
    if (b != 0) {
      return a / (float) b;
    }
    throw new ArithmeticException("B value can't zero");

  }
}
