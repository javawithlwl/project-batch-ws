package com.lwl.learning.jdbc.service;

import com.lwl.common.util.ConnectionUtil;
import com.lwl.learning.jdbc.dao.IplStatDao;
import com.lwl.learning.jdbc.dao.IplStatDaoImpl;
import com.lwl.learning.jdbc.domain.Player;
import com.lwl.learning.jdbc.dto.TeamStatDto;
import com.opencsv.CSVWriter;
import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;

import java.io.FileWriter;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IplStatServiceImpl implements IplStatService {

  private IplStatDao iplStatDao;

  public IplStatServiceImpl() {
    iplStatDao = new IplStatDaoImpl();
  }

  @Override
  public List<Player> playerList() {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    List<Player> list = new ArrayList<>();
    try {
      con = ConnectionUtil.getConnection();
      st = con.createStatement();
      rs = st.executeQuery("select id,name,country,role,team,amount from player");
      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String country = rs.getString("country");
        String role = rs.getString("role");
        String team = rs.getString("team");
        double amount = rs.getDouble("amount");
        Player player = Player.builder()
            .id(id)
            .name(name)
            .amount(amount)
            .country(country)
            .role(role)
            .team(team)
            .build();
        list.add(player);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.close(rs, st, con);
    }
    return list;
  }

  @Override
  public List<TeamStatDto> getTeamStats() {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    List<TeamStatDto> teamsList = new ArrayList<>();
    try {
      con = ConnectionUtil.getConnection();
      st = con.createStatement();
      rs = st.executeQuery("select team,max(amount)as maxAmount,min(amount) as minAmount,count(team) as playerCount,sum(amount) as totalAmount from player group by team");
      while (rs.next()) {
        double totalAmount = rs.getDouble("totalAmount");
        String team = rs.getString("team");
        double minAmount = rs.getDouble("minAmount");
        double maxAmount = rs.getDouble("maxAmount");
        int playerCount = rs.getInt("playerCount");
        TeamStatDto teamStats = TeamStatDto.builder()
            .team(team)
            .minAmount(minAmount)
            .maxAmount(maxAmount)
            .playerCount(playerCount)
            .totalAmount(totalAmount)
            .build();
        teamsList.add(teamStats);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      ConnectionUtil.close(rs, st, con);
    }
    return teamsList;
  }

  @Override
  public List<String> getTeamNames() {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    List<String> teams = new ArrayList<>();
    try {
      con = ConnectionUtil.getConnection();
      st = con.createStatement();
      rs = st.executeQuery("select distinct team from player");
      while (rs.next()) {
        String teamName = rs.getString("team");
        teams.add(teamName);
      }

    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      ConnectionUtil.close(rs, st, con);
    }


    return teams;
  }

  @Override
  public List<Player> getPlayerByTeam(String team) {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    List<Player> playerByTeam = new ArrayList<>();
    try {
      con = ConnectionUtil.getConnection();
      st = con.createStatement();
      rs = st.executeQuery("select id,name,country,role,team,amount from player WHERE team='CSK' ");
      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String country = rs.getString("country");
        String role = rs.getString("role");
        String team1 = rs.getString("team");
        double amount = rs.getDouble("amount");
        Player player = Player.builder()
            .id(id)
            .name(name)
            .amount(amount)
            .country(country)
            .role(role)
            .team(team1)
            .build();
        playerByTeam.add(player);
      }


    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      ConnectionUtil.close(rs, st, con);
    }

    return playerByTeam;
  }

  @Override
  public List<Player> getPlayerByCountry(String country) {
    return iplStatDao.selectPlayerByCountry(country);
  }

  @Override
  public List<Player> topPaidPlayersFromEachTeam() {
    return iplStatDao.selectTopPaidPlayersFromEachTeam();
  }

  @Override
  public int addPlayers(List<Player> list) {
    if (CollectionUtils.isNotEmpty(list)) {
      return iplStatDao.insertPlayers(list);
    }
    throw new IllegalArgumentException("Player list can not be empty or null");
  }

  @Override
  public void export() {
    List<TeamStatDto> teamStatsDtos = getTeamStats();
    Path path = Path.of(System.getProperty("java.io.tmpdir") + "/stats.csv");
    System.out.println(path.toString());

    List<String[]> list = new ArrayList<>();
    for (TeamStatDto teamStatDto : teamStatsDtos) {
      String[] arr = new String[]{
          teamStatDto.getTeam(),
          "" + teamStatDto.getPlayerCount(),
          "" + teamStatDto.getMaxAmount(),
          "" + teamStatDto.getMinAmount()
      };
      list.add(arr);
    }
    writeLineByLine(list, path);


  }

  @SneakyThrows
  private String writeLineByLine(List<String[]> lines, Path path) {
    try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
      for (String[] line : lines) {
        writer.writeNext(line);
      }
      return path.toString();
    }
  }
}
