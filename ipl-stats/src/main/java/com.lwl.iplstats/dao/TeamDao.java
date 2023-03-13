package com.lwl.iplstats.dao;

import com.lwl.iplstats.domain.Team;

import java.io.File;
import java.util.List;

public interface TeamDao {

    int insertTeam(String teamName,String captain);
    List<Team> getTeams();
    Team updateTeam(Team team);
    void uploadImage(int id, File file);
    List<Team> search(String str);
    boolean deleteAll();
}
