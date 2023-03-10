package com.lwl.learning.jdbc.dao;

import com.lwl.learning.jdbc.domain.Player;
import com.lwl.learning.jdbc.dto.TeamStatDto;

import java.util.List;

public interface IplStatDao {
  List<Player> selectPlayers();
  List<TeamStatDto> selectTeamStats();
  List<String> selectTeamNames();
  List<Player> selectPlayerByTeam(String team);
  List<Player> selectPlayerByCountry(String country);
  List<Player> selectTopPaidPlayersFromEachTeam();
  int insertPlayers(List<Player> list);
  int addPlayer(Player player);
  boolean deletePlayer(int id);
  Player selectPlayer(int id);
  Player updatePlayer(Player player);

}
