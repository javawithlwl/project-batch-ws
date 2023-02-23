package com.lwl.capp;

import com.lwl.capp.playerstats.CsvReaderUtil;
import com.lwl.capp.playerstats.Player;
import com.lwl.capp.playerstats.PlayerService;
import com.lwl.capp.playerstats.PlayerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CsvReaderUtilTest {

  @Test
  void checkPlayerCount(){
    List<Player> list = CsvReaderUtil.loadDataFromCsv();
    Assertions.assertEquals(242,list.size());
  }

  @Test
  void teamNamesTest(){
    PlayerService obj = new PlayerServiceImpl();
    System.out.println(obj.getTeamNames());
    Assertions.assertEquals(10,obj.getTeamNames().size());
  }

}
