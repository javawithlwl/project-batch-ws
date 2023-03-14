package com.lwl.iplstats.dao;

import com.lwl.iplstats.domain.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;


public class TeamDaoImplTest {

    private TeamDao teamDao;

    @BeforeEach
    void init(){
        teamDao = new TeamDaoImpl();
        teamDao.deleteAll();
    }
    @Test
    void addTeamTest(){
        String teamName = "CSK";
        String captainName = "Dhoni";
        int id=teamDao.insertTeam(teamName,captainName);
        Assertions.assertTrue(id>0);
    }

    @Test
    void getTeamsTest(){
        String teamName1 = "CSK";
        String captainName1 = "Dhoni";
        teamDao.insertTeam(teamName1,captainName1);
        String teamName2 = "RCB";
        String captainName2 = "ABD";
        teamDao.insertTeam(teamName2,captainName2);
        List<Team> list=teamDao.getTeams();
        Assertions.assertEquals(2,list.size());
    }
    @Test
    void uploadFile(){
        String teamName = "CSK";
        String captainName = "Dhoni";
        int id=teamDao.insertTeam(teamName,captainName);
        teamDao.uploadImage(id,new File("C:\\Users\\lwl\\OneDrive\\Desktop\\ipl_players\\ipl-dhoni.avif"));
    }
    @Test
    void downloadImage(){
        String teamName = "CSK";
        String captainName = "Dhoni";
        int id=teamDao.insertTeam(teamName,captainName);
        teamDao.uploadImage(id,new File("C:\\Users\\lwl\\OneDrive\\Desktop\\ipl_players\\ipl-dhoni.avif"));
        File file = teamDao.downloadImage(id);
        System.out.println("File location :"+file.getAbsolutePath());
    }
}
