package com.lwl.learning.jdbc.dao;

import com.lwl.learning.jdbc.dao.util.ConnectionUtil;
import com.lwl.learning.jdbc.dao.util.ConvertorUtil;
import com.lwl.learning.jdbc.domain.Player;
import com.lwl.learning.jdbc.dto.TeamStatDto;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IplStatDaoImpl implements IplStatDao {
  @Override
  public List<Player> selectPlayers() {
    return null;
  }

  @Override
  public List<TeamStatDto> selectTeamStats() {
    return null;
  }

  @Override
  public List<String> selectTeamNames() {
    return null;
  }

  @Override
  public List<Player> selectPlayerByTeam(String team) {
    return null;
  }

  @Override
  public List<Player> selectPlayerByCountry(String country) {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    List<Player> playerOfGivenCountryList = new ArrayList<>();
    try {
      con = ConnectionUtil.getConnection();
      st = con.prepareStatement(IplStatQueries.PLAYER_OF_GIVEN_TEAM);
      st.setString(1, country);
      rs = st.executeQuery();
      while (rs.next()) {
        Player player = ConvertorUtil.convertResultSetToPlayer(rs);
        playerOfGivenCountryList.add(player);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.close(rs, st, con);
    }
    return playerOfGivenCountryList;
  }

  @Override
  public List<Player> selectTopPaidPlayersFromEachTeam() {
    Connection con = null;
    ResultSet rs = null;
    Statement st = null;
    List<Player> players = new ArrayList<>();
    try {
      con = ConnectionUtil.getConnection();
      st = con.createStatement();
      rs = st.executeQuery(IplStatQueries.TOP_PAID_PLAYERS_OF_EACH_TEAM);
      while (rs.next()) {
        Player player = ConvertorUtil.convertResultSetToPlayer(rs);
        players.add(player);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.close(rs, st, con);
    }
    return players;
  }

  @Override
  @SneakyThrows
  public int insertPlayers(List<Player> list) {
    Connection con = null;
    PreparedStatement st = null;
    List<Player> players = new ArrayList<>();
    int[] count = null;
    try {
      con = ConnectionUtil.getConnection();
      st = con.prepareStatement(IplStatQueries.ADD_PLAYER);
      long startTime = System.currentTimeMillis();
      final int BATCH_SIZE = 50;
      int i = 1;
      for (Player player : list) {
        st.setString(1, player.getName());
        st.setString(2, player.getRole());
        st.setString(3, player.getCountry());
        st.setString(4, player.getTeam());
        st.setDouble(5, player.getAmount());
        i++;
        st.addBatch();
        if (i % BATCH_SIZE == BATCH_SIZE - 1) {
          System.out.println("Batch :"+i);
          st.executeBatch();
        }
      }
      if (list.size() % BATCH_SIZE != 0)
        st.executeBatch();
      long endTime = System.currentTimeMillis();
      System.out.println("Total time :" + (endTime - startTime));
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.close(st, con);
    }
    return count.length;
  }

  @Override
  public int addPlayer(Player player) {
    return 0;
  }

  @Override
  public boolean deletePlayer(int id) {
    return false;
  }

  @Override
  public Player selectPlayer(int id) {
    return null;
  }

  @Override
  public Player updatePlayer(Player player) {
    return null;
  }
}
