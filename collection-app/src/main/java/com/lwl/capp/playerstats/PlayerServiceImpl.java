package com.lwl.capp.playerstats;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerServiceImpl implements  PlayerService{

  private List<Player> players;
  private Map<String, List<Player>> map;

  public PlayerServiceImpl(){

      players = CsvReaderUtil.loadDataFromCsv();
      map = players.stream().collect(Collectors.groupingBy(Player::getTeam));
  }

  @Override
  public List<String> getPlayerNames() {
    List<String> list = players.stream().map(ele -> ele.getName()).collect(Collectors.toList());
    System.out.println("Total player count is "+list.size());
    return list;
  }

  @Override
  public List<String> getTeamNames() {
    List<String> list = new ArrayList<>();
    Set<String> teamNames = players.stream().map(ele -> ele.getTeam()).collect(Collectors.toSet());
   list.addAll(teamNames);


    return list;
  }

  @Override
  public List<Player> getPlayerByTeam(String team) {

     List<Player> player= players.stream().filter(ele->ele.getTeam().equalsIgnoreCase(team)).collect(Collectors.toList());
    return player;
  }

  @Override
  public List<Player> getPlayerByRole(String role) {
       List<Player> player = players.stream().filter(ele->ele.getRole().equalsIgnoreCase(role)).collect(Collectors.toList());

    return player;
  }

  @Override
  public List<TeamStatsDto> getTeamStats() {
    return null;
  }

  @Override
  public List<Player> getMaxPaidPlayers()
  {
    double maxAmount = getMaxAmount();
     List<Player> player = players.stream().filter(ele->ele.getAmount()==maxAmount).collect(Collectors.toList());
    return player;
  }

  private double getMaxAmount() {
    double maxAmount = players.get(0).getAmount();

    for(int i = 1;i<players.size();i++) {
      if(players.get(i).getAmount()>maxAmount) {
        maxAmount = players.get(i).getAmount();
      }
    }
    return maxAmount;


  }

  @Override
  public List<Player> getMaxPaidPlayers(String team) {
    List<Player> players = map.get(team);
      List<Player> playersByTeam = players.stream().filter(ele->ele.getTeam().equalsIgnoreCase(team)).collect(Collectors.toList());
      double maxAmount = getMaxAmountByTeam(playersByTeam);
       List<Player> maxPaidPlayerByTeam = playersByTeam.stream().filter(ele->ele.getAmount()==maxAmount).collect(Collectors.toList());

    return maxPaidPlayerByTeam;
  }

  private double getMaxAmountByTeam(List<Player> playersByTeam) {
    double max = playersByTeam.get(0).getAmount();

    for(Player player:playersByTeam){
      if(player.getAmount()>max){
        max = player.getAmount();
      }

    }
    return max;


  }

  @Override
  public List<Player> getMaxPaidPlayers(String team, String role) {

    List<Player> players = map.get(team);
     List<Player> playersByRole = players.stream().filter(ele->ele.getRole().equalsIgnoreCase(role)).collect(Collectors.toList());
    double maxAmount = getMaxAmountByTeamAndRole(playersByRole);
      List<Player> maxPaidPlayers =  playersByRole.stream().filter(ele->ele.getAmount()==maxAmount).collect(Collectors.toList());




    return maxPaidPlayers;
  }
  private double getMaxAmountByTeamAndRole(List<Player> playersByRole) {
    double max = playersByRole.get(0).getAmount();
    for (Player player : playersByRole) {
      double amount = player.getAmount();
      if (amount > max) {
        max = amount;
      }
    }
    return max;
  }

  @Override
  public List<String> getCountryNames() {
    List<String> list = new ArrayList<>();
    Set<String> country = players.stream().map(ele->ele.getCountry()).collect(Collectors.toSet());
     list.addAll(country);

    return list;
  }

  @Override
  public List<CountryStatsDto> getPlayerCountryStats() {
    return null;
  }
}
