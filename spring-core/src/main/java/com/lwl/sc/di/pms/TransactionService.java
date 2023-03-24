package com.lwl.sc.di.pms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class TransactionService {

  private Parser parser;

  public TransactionService(@Qualifier("icici") Parser parser) {
    this.parser = parser;
  }

  public void uploadTransactionDetails(File file) {
    List<String> list = parser.parse(file);
    System.out.println(list);

  }
}
