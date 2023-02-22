package com.lwl.capp.playerstats;

import java.util.List;

public interface PlayerService {

       List<String> getPlayerNames();
       List<String> getTeamNames(); // Shouldn't contains any duplicates
       List<Player> getPlayerByTeam(String team);
       List<Player> getPlayerByRole(String role);
       List<TeamStatsDto> getTeamStats();
       List<Player> getMaxPaidPlayers();
       List<Player> getMaxPaidPlayers(String team);
       List<Player> getMaxPaidPlayers(String team,String role);
       List<String> getCountryNames();
       List<CountryStatsDto> getPlayerCountryStats();
}
