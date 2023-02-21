package com.lwl.quiz.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionBank {
      private List<QuestionDetails> questions;
}
