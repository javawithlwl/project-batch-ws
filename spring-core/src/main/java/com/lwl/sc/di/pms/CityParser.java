package com.lwl.sc.di.pms;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CityParser implements  Parser{
  @Override
  public List<String> parse(File file) {
    return List.of("CITY");
  }
}
