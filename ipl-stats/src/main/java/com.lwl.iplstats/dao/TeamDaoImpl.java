package com.lwl.iplstats.dao;

import static com.lwl.common.util.ConnectionUtil.*;

import com.lwl.common.util.AwsS3Service;
import com.lwl.iplstats.domain.Team;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDaoImpl implements TeamDao {
  @Override
  public int insertTeam(String teamName, String captainName) {

    Connection con = null;
    PreparedStatement pst = null;
    try {
      con = getConnection();
      pst = con.prepareStatement("insert into team(name,captain) values(?,?)", Statement.RETURN_GENERATED_KEYS);
      pst.setString(1, teamName);
      pst.setString(2, captainName);
      int count = pst.executeUpdate();
      ResultSet rs = pst.getGeneratedKeys();
      if (rs.next()) {
        int key = rs.getInt("id");
        System.out.println("Team is added with id :" + key);
        return key;
      }
    } catch (SQLException e) {
      System.out.println("While adding team :" + e);
    } finally {
      close(pst, con);
    }
    return -1;
  }

  @Override
  public List<Team> getTeams() {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    List<Team> teams = new ArrayList<>();
    try {
      con = getConnection();
      st = con.createStatement();
      rs = st.executeQuery("select id,name,captain,captain_img_url from team");
      while (rs.next()) {
        Team team = Team.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .captain(rs.getString("captain"))
            .captainImgUrl(rs.getString("captain_img_url"))
            .build();
        teams.add(team);
      }

    } catch (SQLException e) {
      System.out.println("While adding team :" + e);
    } finally {
      close(rs, st, con);
    }
    return teams;
  }

  @Override
  public Team updateTeam(Team team) {
    return null;
  }

  @Override
  public void uploadImage(int id, File file) {
    String key = "ipl-captain-images/"+id+"_"+file.getName();
    AwsS3Service awsS3Service = new AwsS3Service();
    awsS3Service.uploadFile("ipl-docs", key, file);
    System.out.println("File is uploaded into s3");
    updatePlayerImageUrl(id,key);
  }

  private void updatePlayerImageUrl(int id, String key) {
    Connection con = null;
    PreparedStatement pst = null;
    try {
      con = getConnection();
      pst = con.prepareStatement("update team set captain_img_url=? where id=?");
      pst.setInt(2,id);
      pst.setString(1,key);
      pst.executeUpdate();
    } catch (SQLException e) {
      System.out.println("While updating team :" + e);
    } finally {
      close(pst, con);
    }
  }

  @Override
  public List<Team> search(String str) {
    return null;
  }

  @Override
  public boolean deleteAll() {
    Connection con = null;
    PreparedStatement pst = null;
    try {
      con = getConnection();
      pst = con.prepareStatement("delete from team");
      int count = pst.executeUpdate();
      return count > 0;
    } catch (SQLException e) {
      System.out.println("While adding team :" + e);
    } finally {
      close(pst, con);
    }
    return false;
  }

  @Override
  public File downloadImage(int id) {
    AwsS3Service obj = new AwsS3Service();
    Team team = selectTeam(id);
    String path = obj.downloadImage("ipl-docs",team.getCaptainImgUrl());
    System.out.println("Image location :"+path);
    return new File(path);
  }

  @Override
  public Team selectTeam(int id) {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      pst = con.prepareStatement("select id,name,captain,captain_img_url from team where id=?");
      pst.setInt(1,id);
      rs = pst.executeQuery();
      if(rs.next()){
        Team team = new Team();
        team.setCaptain(rs.getString("captain"));
        team.setId(rs.getInt("id"));
        team.setCaptainImgUrl(rs.getString("captain_img_url"));
        team.setName(rs.getString("name"));
        return team;
      }
    } catch (SQLException e) {
      System.out.println("While updating team :" + e);
    } finally {
      close(pst, con);
    }
    throw new IllegalArgumentException("Team with given id "+id+" is not found");
  }
}
