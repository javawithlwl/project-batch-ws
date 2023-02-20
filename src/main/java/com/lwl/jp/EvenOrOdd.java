package com.lwl.jp;

import java.util.Scanner;

public class EvenOrOdd {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the num: ");
    int num = sc.nextInt();
    System.out.println(num % 2 == 0 ? num+ " is even" : num+ " is odd");

  }

}
