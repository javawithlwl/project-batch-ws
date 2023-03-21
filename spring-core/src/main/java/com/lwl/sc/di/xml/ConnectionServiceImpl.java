package com.lwl.sc.di.xml;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
public class ConnectionServiceImpl implements  ConnectionService {

  private String url;
  private String username;
  private String password;
  @Override
  public Connection getConnection() {
      Connection con = null;
      try{
          con = DriverManager.getConnection(url,username,password);
      }catch (SQLException e){
        e.printStackTrace();
      }
      return con;
  }
}
