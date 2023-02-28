package com.lwl.capp.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lwl.capp.playerstats.CsvReaderUtil;
import com.lwl.capp.playerstats.Player;

import lombok.Builder;
import lombok.Data;

@Data
class PlayerInfo {
	private String name;
	private String country;
	private double amount;
}

@Data
class RoleInfo {
	private String rolename;
	private List<PlayerInfo> players1;
}

@Data
class TeamsInfo {
	private String team;
	private List<RoleInfo> roles;
}

@Data
class Teams{
	private List<TeamsInfo> teams;
}

public class IplStatManager {

	public static void main(String[] args) throws IOException {
		List<Player> players = CsvReaderUtil.loadDataFromCsv();
		Set<String> teamsnames = players.stream().map(p -> p.getTeam()).collect(Collectors.toSet());
		Map<String, List<Player>> play = players.stream().collect(Collectors.groupingBy(Player::getTeam));
		List<TeamsInfo> teams1 = new ArrayList<>();
		for (String tem : teamsnames) {
			List<Player> teamPlayers = play.get(tem);
			Map<String, List<Player>> roleplayerMap = teamPlayers.stream().collect(Collectors.groupingBy(Player::getRole));
			List<RoleInfo> roleInfoList = new ArrayList<>();
			roleplayerMap.forEach((rolen,roleplayers)->{
				RoleInfo obj = new RoleInfo();
				obj.setRolename(rolen);
				List<PlayerInfo> playerInfoLIst = new ArrayList<>();
				for(Player p : roleplayers) {
					PlayerInfo playerInfo = new PlayerInfo();
					playerInfo.setName(p.getName());
					playerInfo.setCountry(p.getCountry());
					playerInfo.setAmount(p.getAmount());
					playerInfoLIst.add(playerInfo);
				}
				obj.setPlayers1(playerInfoLIst);
				roleInfoList.add(obj);
			});
			TeamsInfo teamsInfo = new TeamsInfo();
			teamsInfo.setTeam(tem);
			teamsInfo.setRoles(roleInfoList);
			teams1.add(teamsInfo);
		}
		Teams teams = new Teams();
		teams.setTeams(teams1);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		System.out.println(objectMapper.writeValueAsString(teams));
		objectMapper.writeValue(new File("player12.json"), teams);
}
}