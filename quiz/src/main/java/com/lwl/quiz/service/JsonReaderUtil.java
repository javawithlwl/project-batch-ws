package com.lwl.quiz.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwl.quiz.domain.QuestionBank;
import com.lwl.quiz.domain.QuestionDetails;
import lombok.SneakyThrows;

import java.util.List;

public class JsonReaderUtil {
      @SneakyThrows
      public List<QuestionDetails> loadQuestions(){
            ObjectMapper objectMapper = new ObjectMapper();
            QuestionBank questionBank = objectMapper.readValue(this.getClass().getResourceAsStream("/quiz_data.json"), QuestionBank.class);
            return questionBank.getQuestions();
      }
}
