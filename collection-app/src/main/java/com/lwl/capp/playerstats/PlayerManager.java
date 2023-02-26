package com.lwl.capp.playerstats;

import java.util.List;

public class PlayerManager {

	public static void main(String[] args) {
		PlayerServiceImpl ps = new PlayerServiceImpl();
		ps.getPlayerNames();
		ps.getTeamNames();
		ps.getCountryNames();
		ps.getTeamStats();
		ps.getPlayerCountryStats();
		ps.getMaxPaidPlayers();
		ps.getMaxPaidPlayers("mi", "batsman");
		ps.getMaxPaidPlayers("srh");
		ps.getPlayerByRole("batsman");
		ps.getPlayerByTeam("rcb");
	}

}
