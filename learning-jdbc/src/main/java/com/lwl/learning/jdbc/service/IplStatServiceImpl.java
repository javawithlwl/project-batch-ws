package com.lwl.learning.jdbc.service;

import com.lwl.learning.jdbc.ConnectionUtil;
import com.lwl.learning.jdbc.domain.Player;
import com.lwl.learning.jdbc.dto.TeamStatDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IplStatServiceImpl implements  IplStatService{
  @Override
  public List<Player> playerList() {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    List<Player> list = new ArrayList<>();
    try{
        con = ConnectionUtil.getConnection();
        st = con.createStatement();
        rs = st.executeQuery("select id,name,country,role,team,amount from player");
        while(rs.next()){
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
    }catch (SQLException e){
        e.printStackTrace();
    }finally{
        ConnectionUtil.close(rs,st,con);
    }
    return list;
  }

  @Override
  public List<TeamStatDto> getTeamStats() {

      Connection con = null;
      Statement st = null;
      ResultSet rs = null;
      List<String> teams = getTeamNames();
      List<Player> player = playerList();
      List<TeamStatDto> teamsList = new ArrayList<>();
      try{
          con = ConnectionUtil.getConnection();
          st = con.createStatement();
          rs = st.executeQuery("select team,max(amount)as maxAmount,min(amount) as minAmount,count(team) as playerCount,sum(amount) as totalAmount from player group by team ");
          while(rs.next()) {
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

      }
      catch (SQLException e){
          e.printStackTrace();

      }
      finally {
          ConnectionUtil.close(rs,st,con);
      }
    return teamsList;
  }
    @Override
  public List<String> getTeamNames() {
      Connection con = null;
      Statement st = null;
      ResultSet rs = null;
      List<String> teams = new ArrayList<>();
      try{
          con = ConnectionUtil.getConnection();
          st = con.createStatement();
          rs = st.executeQuery("select distinct team from player");
          while(rs.next()) {
              String teamName = rs.getString("team");
              teams.add(teamName);
          }

      }catch (SQLException e){
          e.printStackTrace();

      }finally {
          ConnectionUtil.close(rs,st,con);
      }


      return teams;
  }

  @Override
    public List<Player> getPlayerByTeam(String team) {
      Connection con = null;
      Statement st = null;
      ResultSet rs = null;
      List<Player> playerByTeam = new ArrayList<>();
      try{
          con = ConnectionUtil.getConnection();
          st = con.createStatement();
          rs = st.executeQuery("select id,name,country,role,team,amount from player WHERE team='CSK' ");
          while(rs.next()){
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


      }catch (SQLException e){
          e.printStackTrace();

      }finally {
          ConnectionUtil.close(rs,st,con);
      }

    return playerByTeam;
  }

  @Override
  public List<Player> getPlayerByCountry(String country) {
      Connection con = null;
      Statement st = null;
      ResultSet rs = null;
      List<Player> playerByCountry = new ArrayList<>();
      try{
          con = ConnectionUtil.getConnection();
          st = con.createStatement();
         rs = st.executeQuery("select id,name,country,role,team,amount from player WHERE country='India' ");
          while(rs.next()){
              int id = rs.getInt("id");
              String name = rs.getString("name");
              String country1 = rs.getString("country");
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
              playerByCountry.add(player);
          }


      }catch (SQLException e){
          e.printStackTrace();

      }finally {
          ConnectionUtil.close(rs,st,con);
      }

      return playerByCountry;
  }

  @Override
  public List<Player> topPaidPlayersFromEachTeam() {
      Connection con = null;
      Statement st = null;
      ResultSet rs = null;
      List<Player> players = new ArrayList<>();
      try{
          con = ConnectionUtil.getConnection();
          st = con.createStatement();
          rs = st.executeQuery("select t.id,t.name,t.role,t.team,t.country,t.amount from(select id,name,role,team,country,amount,dense_rank() over( partition by team order by amount desc) rnk from player p order by amount desc) t where t.rnk = 1;");
          while(rs.next()){
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
              players.add(player);
          }


      }catch (SQLException e){
          e.printStackTrace();

      }finally {
          ConnectionUtil.close(rs,st,con);
      }


      return players;
  }
}
