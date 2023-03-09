package com.lwl.learning.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public final class ConnectionUtil {

  private static Properties properties;

  static {
    properties = new Properties();
    try {
      properties.load(ConnectionUtil.class.getResourceAsStream("/db_config.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static Connection getConnection() {
    Connection con = null;
    try {
      con = DriverManager.getConnection(properties.getProperty("jdbc.url"),
          properties.getProperty("jdbc.username"),
          properties.getProperty("jdbc.password"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return con;
  }
  public static void close(ResultSet rs, Statement st,Connection con){
      try{
          if(rs!=null){
            rs.close();
          }
          if(st!=null){
            st.close();
          }
          if(con!=null){
              st.close();
          }
      }catch (SQLException e){
          e.printStackTrace();
      }
  }

}
