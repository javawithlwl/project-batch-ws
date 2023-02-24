package com.lwl.quiz.service;

import java.util.Set;

public interface QuizService {

      public void startQuiz(String username,String subject);
      public Set<String> getSubjectNames();
}
