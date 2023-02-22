package com.lwl.capp.playerstats;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerServiceImpl implements  PlayerService{

  private List<Player> players;

  public PlayerServiceImpl(){
      players = CsvReaderUtil.loadDataFromCsv();
  }

  @Override
  public List<String> getPlayerNames() {
    List<String> list = players.stream().map(ele -> ele.getName()).collect(Collectors.toList());
    System.out.println("Total player count is "+list.size());
    return list;
  }

  @Override
  public List<String> getTeamNames() {
    return null;
  }

  @Override
  public List<Player> getPlayerByTeam(String team) {
    return null;
  }

  @Override
  public List<Player> getPlayerByRole(String role) {
    return null;
  }

  @Override
  public List<TeamStatsDto> getTeamStats() {
    return null;
  }

  @Override
  public List<Player> getMaxPaidPlayers() {
    return null;
  }

  @Override
  public List<Player> getMaxPaidPlayers(String team) {
    return null;
  }

  @Override
  public List<Player> getMaxPaidPlayers(String team, String role) {
    return null;
  }

  @Override
  public List<String> getCountryNames() {
    return null;
  }

  @Override
  public List<CountryStatsDto> getPlayerCountryStats() {
    return null;
  }
}
