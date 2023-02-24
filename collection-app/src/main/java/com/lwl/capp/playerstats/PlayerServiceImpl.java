package com.lwl.capp.playerstats;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerServiceImpl implements PlayerService {

  private List<Player> players;
  private Map<String, List<Player>> map;

  public PlayerServiceImpl() {
    players = CsvReaderUtil.loadDataFromCsv();
    map = players.stream().collect(Collectors.groupingBy(Player::getTeam));
  }

  @Override
  public List<String> getPlayerNames() {
    List<String> list = players.stream().map(ele -> ele.getName()).collect(Collectors.toList());
    System.out.println("Total player count is " + list.size());
    return list;
  }

  @Override
  public List<String> getTeamNames() {
    Set<String> teamNames = players.stream().map(ele -> ele.getTeam()).collect(Collectors.toSet());
    List<String> list = new ArrayList<>(teamNames);
    System.out.println("Total team count is " + list.size());
    return list;
  }

  @Override
  public List<Player> getPlayerByTeam(String team) {
    List<Player> players = map.get(team);
    System.out.println("The team " + team + " has " + players.size() + " players");
    return players;
  }

  @Override
  public List<Player> getPlayerByRole(String role) {
    List<Player> player = players.stream()
        .filter(ele -> ele.getRole().equalsIgnoreCase(role))
        .collect(Collectors.toList());
    System.out.println("The role " + role + " has " + players.size() + " players");
    return player;
  }

  @Override
  public List<Player> getMaxPaidPlayers() {
    double maxAmount = getMaxAmount(players);
    List<Player> player = players.stream().filter(ele -> ele.getAmount() == maxAmount).collect(Collectors.toList());
    System.out.println("Max amount is " + maxAmount + " and max paid player count is " + player.size());
    return player;
  }

  @Override
  public List<Player> getMaxPaidPlayers(String team) {
    List<Player> players = map.get(team);
    double maxAmount = getMaxAmount(players);
    List<Player> maxPaidPlayers = players.stream()
        .filter(ele -> ele.getAmount() == maxAmount)
        .collect(Collectors.toList());
    System.out.println("Team " + team + " max amount " + maxAmount + " and max paid player count  " + maxPaidPlayers.size());
    return maxPaidPlayers;
  }

  @Override
  public List<Player> getMaxPaidPlayers(String team, String role) {
    List<Player> players = map.get(team);
    List<Player> playerByRoleList = players.stream().filter(p -> p.getRole().equals(role)).collect(Collectors.toList());
    double maxAmount = getMaxAmount(playerByRoleList);
    List<Player> maxPaidPlayers = playerByRoleList.stream()
        .filter(ele -> ele.getAmount() == maxAmount)
        .collect(Collectors.toList());
    System.out.println("Team " + team + " role " + role + " max amount " + maxAmount + " and max paid player count  " + maxPaidPlayers.size());
    return maxPaidPlayers;
  }

  @Override
  public List<String> getCountryNames() {
    Set<String> country = players.stream().map(ele -> ele.getCountry()).collect(Collectors.toSet());
    List<String> list = new ArrayList<>(country);
    System.out.println("Country count is :" + list.size());
    return list;
  }

  @Override
  public List<CountryStatsDto> getPlayerCountryStats() {
    List<String> countryList = getCountryNames();
    List<CountryStatsDto> countryStatsList = new ArrayList<>();
    for (String country : countryList) {
      List<Player> playerList = players.stream().filter(p -> p.getCountry().equals(country)).collect(Collectors.toList());
      double maxAmount = getMaxAmount(playerList);
      double minAmount = getMinAmount(playerList);
      double totalAmount = playerList.stream().mapToDouble(p -> p.getAmount()).sum();
      int count = playerList.size();
      CountryStatsDto obj = CountryStatsDto.builder()
          .maxAmount(maxAmount)
          .minAmount(minAmount)
          .totalAmount(totalAmount)
          .country(country)
          .playerCount(count)
          .build();
      countryStatsList.add(obj);
    }
    return countryStatsList;
  }
  @Override
  public List<TeamStatsDto> getTeamStats() {
    List<String> teamList = getTeamNames();
    List<TeamStatsDto> teamStatsList = new ArrayList<>();
    for(String teams :teamList){
      List<Player> list =  players.stream().filter(t->t.getTeam().equalsIgnoreCase(teams)).collect(Collectors.toList());
      String team = teams;
      int playerCount = list.size();
      double totalAmount =list.stream().mapToDouble(p -> p.getAmount()).sum();
      TeamStatsDto obj = TeamStatsDto.builder()
              .team(team)
              .playerCount(playerCount)
              .totalAmount(totalAmount)
              .build();
      teamStatsList.add(obj);

    }
    return teamStatsList;
  }

  private double getMinAmount(List<Player> playerList) {
    double minAmount = playerList.get(0).getAmount();
    for (int i = 1; i < playerList.size(); i++) {
      if (playerList.get(i).getAmount() < minAmount) {
        minAmount = playerList.get(i).getAmount();
      }
    }
    return minAmount;
  }

  private double getMaxAmount(List<Player> playerList) {
    double maxAmount = playerList.get(0).getAmount();
    for (int i = 1; i < playerList.size(); i++) {
      if (playerList.get(i).getAmount() > maxAmount) {
        maxAmount = playerList.get(i).getAmount();
      }
    }
    return maxAmount;
  }
}
