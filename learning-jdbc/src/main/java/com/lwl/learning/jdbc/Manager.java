package com.lwl.learning.jdbc;

import com.lwl.learning.jdbc.domain.Player;
import com.lwl.learning.jdbc.service.IplStatService;
import com.lwl.learning.jdbc.service.IplStatServiceImpl;

import java.util.List;

public class Manager {

  public static void main(String[] args) {

    IplStatService iplStatService = new IplStatServiceImpl();
    List<Player> players = iplStatService.playerList();
    System.out.println("Total player count :"+players.size());

  }
}
