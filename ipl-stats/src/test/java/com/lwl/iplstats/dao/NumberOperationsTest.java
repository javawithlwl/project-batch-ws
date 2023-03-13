package com.lwl.iplstats.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberOperationsTest {
  private NumberOperations obj;

  @BeforeEach
  void init() {
    obj = new NumberOperations();
  }

  @Test
  void firstValueAsBig() {
    int a = 20, b = 10, c = 5;
    int res = obj.biggest(a, b, c);
    Assertions.assertEquals(20, res);
  }

  @Test
  void secondValueAsBig() {
    int a = 10, b = 20, c = 5;
    int res = obj.biggest(a, b, c);
    Assertions.assertEquals(20, res);
  }

  @Test
  void thirdValueAsBig() {
    int a = 5, b = 10, c = 20;
    int res = obj.biggest(a, b, c);
    Assertions.assertEquals(20, res);
  }

  @Test
  void allValuesAsBig() {
    int a = 20, b = 20, c = 20;
    int res = obj.biggest(a, b, c);
    Assertions.assertEquals(20, res);
  }
}
