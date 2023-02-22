package com.lwl.capp.playerstats;

import java.util.List;

public class PlayerServiceImpl implements  PlayerService{

  private List<Player> players;

  public PlayerServiceImpl(){
      players = CsvReaderUtil.loadDataFromCsv();
  }

  @Override
  public List<String> getPlayerNames() {
    return null;
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
