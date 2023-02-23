package com.lwl.capp.playerstats;

import java.util.List;

public class PlayerManager {
    public static void main(String[] args) {
        PlayerServiceImpl service = new PlayerServiceImpl();

//       List<String> list =  service.getTeamNames();
//       System.out.println(list);
//
//       List<Player> list1 = service.getPlayerByTeam("CSK");
//       System.out.println(list1);
//        List<Player> list2 =  service.getPlayerByRole("Bowler");
//        System.out.println(list2);
//        List<Player> player = service.getMaxPaidPlayers();
//        System.out.println(player);
//       List<Player> player1 = service.getMaxPaidPlayers("DC");
//       System.out.println(player1);
//      List<String> country =  service.getCountryNames();
//      System.out.println(country);
      List<Player> maxPaidPlayers = service.getMaxPaidPlayers("DC","Batsman");
      System.out.println(maxPaidPlayers);
//     List<Player> player3= service.getMaxPaidPlayers("PBKS");
//     System.out.println(player3);
      System.out.println(service.getPlayerCountryStats());
    }




}
