package com.lwl.quiz.service;

import com.lwl.quiz.domain.QuestionDetails;
import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class QuizServiceImpl implements QuizService {

  private JsonReaderUtil jsonReaderUtil;
  private List<QuestionDetails> questions;

  public QuizServiceImpl() {
    jsonReaderUtil = new JsonReaderUtil();
    questions = jsonReaderUtil.loadQuestions();
  }


  @Override
  @SneakyThrows
  public void startQuiz(String username, String subject) {
    List<QuestionDetails> quizQuestions = questions.stream().filter(ele -> ele.getSubject().equalsIgnoreCase(subject)).collect(Collectors.toList());
    System.out.println("Hi " + username + ", your quiz is going start in few seconds, please wait");
    Thread.sleep(3000);
    Scanner sc = new Scanner(System.in);
    int num = 1;
    int canswers = 0;
    for (QuestionDetails questionDetails : quizQuestions) {
      System.out.println(num++ + ") " + questionDetails.getQuestion());
      int i = 0;
      System.out.println();
      for (String option : questionDetails.getOptions()) {
        System.out.println("\t" + (i + 1) + ") " + option);
        i++;
      }
      System.out.println("Enter your answers :");
      int userAnswer = sc.nextInt();
      if ((userAnswer - 1) == questionDetails.getAnswer()) {
        canswers++;
      }
    }
    int totalQuestions = quizQuestions.size();
    float result = ((canswers) / (float) totalQuestions) * 100;
    System.out.println("Hi " + username + ", You have scored " + result + "%" + " in " + subject);
  }

  @Override
  public Set<String> getSubjectNames() {
    Set<String> subjectNames = new HashSet<>();
    if (!questions.isEmpty()) {
      for (QuestionDetails q : questions) {
        subjectNames.add(q.getSubject());
      }
    } else {
      throw new IllegalArgumentException("Question list empty");
    }
    return subjectNames;
  }
}
