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
  public List<Player> getPlayerByCountry(String country) {
    return null;
  }

  @Override
  public List<Player> topPaidPlayersFromEachTeam() {
    return null;
  }
}
