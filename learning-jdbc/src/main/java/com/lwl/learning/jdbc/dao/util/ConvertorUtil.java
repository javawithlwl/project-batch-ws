package com.lwl.learning.jdbc.dao.util;

import com.lwl.learning.jdbc.domain.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConvertorUtil {

  public static Player convertResultSetToPlayer(ResultSet rs) {
    Player player = null;
    try {
      player = Player.builder().id(rs.getInt("id"))
          .name(rs.getString("name"))
          .team(rs.getString("team"))
          .role(rs.getString("role"))
          .country(rs.getString("country"))
          .amount(rs.getDouble("amount")).build();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return player;
  }

}
