package com.lwl.learning.jdbc.service;

import com.lwl.learning.jdbc.domain.Player;
import com.lwl.learning.jdbc.dto.TeamStatDto;

import java.util.List;

public interface IplStatService {

    List<Player> playerList();
    List<TeamStatDto> getTeamStats();
    List<String> getTeamNames();
    List<Player> getPlayerByTeam(String team);
    List<Player> getPlayerByCountry(String country);
    List<Player> topPaidPlayersFromEachTeam();
    int addPlayers(List<Player> list);
    void export();

}
