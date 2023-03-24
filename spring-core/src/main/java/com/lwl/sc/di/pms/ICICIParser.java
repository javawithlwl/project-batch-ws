package com.lwl.sc.di.pms;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service("icici")
public class ICICIParser implements  Parser{
  @Override
  public List<String> parse(File file) {
    return List.of("ICICI");
  }
}
