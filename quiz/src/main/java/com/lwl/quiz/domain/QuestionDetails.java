package com.lwl.quiz.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDetails {
      private String question;
      private List<String> options;
      private int answer;
      private String subject;
}
