package com.lwl.capp.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.apache.commons.collections4.functors.ForClosure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lwl.capp.playerstats.CsvReaderUtil;
import com.lwl.capp.playerstats.Player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
class PlayerInfo {
	private String name;
	private String country;
	private double amount;
}

@Data
@Builder
class RoleInfo {
	private String rolename;
	private List<PlayerInfo> players1;
}

@Data
@Builder
class TeamsInfo {
	private String team;
	private List<RoleInfo> roles;
}

public class IplStatManager {

	public static void main(String[] args) throws IOException {
		List<Player> players = CsvReaderUtil.loadDataFromCsv();
		Set<String> teamsnames = players.stream().map(p -> p.getTeam()).collect(Collectors.toSet());
		Set<String> rolenames = players.stream().map(p -> p.getRole()).collect(Collectors.toSet());
		Map<String, List<TeamsInfo>> play = new HashMap<>();
		List<TeamsInfo> teamsList = new ArrayList<>();
		List<RoleInfo> rolesList = new ArrayList<>();
		List<PlayerInfo> playerList = new ArrayList<>();
		List<Player> playerByTeam = new ArrayList<>();
		List<Player> playerByRole = new ArrayList<>();
		for (String tem : teamsnames) {
			playerByTeam = players.stream().filter(pla->pla.getTeam().equals(tem)).collect(Collectors.toList());
			RoleInfo roleInfo = null;
			for(String rol: rolenames) {
				playerByRole = playerByTeam.stream().filter(pla->pla.getRole().equals(rol)).collect(Collectors.toList());
				roleInfo = RoleInfo.builder()
						.rolename(rol).players1(playerList).build();
				rolesList.add(roleInfo);
				PlayerInfo playerInfo = null;
				for (Player player : playerByRole) {
					playerInfo = PlayerInfo.builder()
							.name(player.getName())
							.country(player.getCountry())
							.amount(player.getAmount())
							.build();
					playerList.add(playerInfo);
				}
			}
			TeamsInfo teamsInfo = TeamsInfo.builder()
					.team(tem).roles(rolesList).build();
			teamsList.add(teamsInfo);
		}
		play.put("teams", teamsList);
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	    objectMapper.writeValue(new File("players11.json"),play);
		
	}
}
