package com.lwl.capp;

import com.lwl.capp.playerstats.CsvReaderUtil;
import com.lwl.capp.playerstats.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CsvReaderUtilTest {

  @Test
  void checkPlayerCount(){
    List<Player> list = CsvReaderUtil.loadDataFromCsv();
    Assertions.assertEquals(242,list.size());
  }
}
