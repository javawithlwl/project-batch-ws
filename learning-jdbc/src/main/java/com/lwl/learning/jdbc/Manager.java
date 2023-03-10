package com.lwl.learning.jdbc;

import com.lwl.learning.jdbc.domain.Player;
import com.lwl.learning.jdbc.dto.TeamStatDto;
import com.lwl.learning.jdbc.service.IplStatService;
import com.lwl.learning.jdbc.service.IplStatServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Manager {

  public static void main(String[] args) {

    IplStatService iplStatService = new IplStatServiceImpl();
    List<Player> players = iplStatService.playerList();
    System.out.println("Total player count :"+players.size());
    List<String> teams = iplStatService.getTeamNames();
    System.out.println("Teams are:"+teams);
    List<Player> playerByTeam =iplStatService.getPlayerByTeam("CSK");
    System.out.println("Players of respective team"+playerByTeam);
    List<Player> playerByCountry = iplStatService.getPlayerByCountry("India");
    System.out.println("Players of respective country:"+playerByCountry);
    List<Player> players1 = iplStatService.topPaidPlayersFromEachTeam();
    System.out.println("Top paid players for Each Team "+players1);
    List<TeamStatDto> teamStats = iplStatService.getTeamStats();
    System.out.println("TeamStats:"+teamStats);
    System.out.println("TeamStats:"+teamStats.size());



  }
}
