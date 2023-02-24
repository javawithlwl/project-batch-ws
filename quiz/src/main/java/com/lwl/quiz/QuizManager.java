package com.lwl.quiz;

import com.lwl.quiz.service.QuizService;
import com.lwl.quiz.service.QuizServiceImpl;

import java.util.Scanner;
import java.util.Set;

public class QuizManager {

  public static void main(String[] args) {

    QuizService quizService = new QuizServiceImpl();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your name :");
    String name = sc.nextLine();
    Set<String> subjectName = quizService.getSubjectNames();
    System.out.println("Subject name :");
    for(String sname:subjectName){
      System.out.println(sname);
    }
    System.out.println("Enter the subject name:");
    String subName = sc.nextLine();
    quizService.startQuiz(name,subName);
  }
}
