package com.lwl.capp.playerstats;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlayerServiceImpl implements PlayerService {

	private List<Player> players;

	public PlayerServiceImpl() {
		players = CsvReaderUtil.loadDataFromCsv();
	}

	@Override
	public List<String> getPlayerNames() {
		List<String> list = players.stream().map(ele -> ele.getName()).collect(Collectors.toList());
		System.out.println("Total player count is " + list.size());
		return list;
	}

	@Override
	public List<String> getTeamNames() {
		Set<String> teamSet = players.stream().map(ele -> ele.getTeam()).collect(Collectors.toSet());
		System.out.println("total no of teams are " + teamSet.size());
		System.out.println(teamSet);
		List<String> teamList = new ArrayList<String>(teamSet);
		return teamList;
	}

	@Override
	public List<Player> getPlayerByTeam(String team) {
		List<Player> playerByTeam = players.stream().filter(tem -> tem.getTeam().equalsIgnoreCase(team))
				.collect(Collectors.toList());
		System.out.println("the no of players from " + team + " is " + playerByTeam.size());
		return playerByTeam;
	}

	@Override
	public List<Player> getPlayerByRole(String role) {
		List<Player> playerByRole = players.stream().filter(tem -> tem.getRole().equalsIgnoreCase(role))
				.collect(Collectors.toList());
		System.out.println("the no of players belongs to " + role + " is" + playerByRole.size());
		return playerByRole;
	}

	@Override
	public List<TeamStatsDto> getTeamStats() {
		List<String> teams = getTeamNames();
		List<TeamStatsDto> teamStatsList = new ArrayList<>();
		for (String tem : teams) {
			List<Player> plaByTeam = players.stream().filter(t -> t.getTeam().equals(tem)).collect(Collectors.toList());
			int count = plaByTeam.size();
			double total = plaByTeam.stream().mapToDouble(t -> t.getAmount()).sum();
			TeamStatsDto tsd = TeamStatsDto.builder().team(tem).totalAmount(total).playerCount(count).build();
			teamStatsList.add(tsd);
		}
		System.out.println(teamStatsList);
		return teamStatsList;
	}

	@Override
	public List<Player> getMaxPaidPlayers() {
		double maxAmount = maxAmount(players);
		List<Player> maxPaidPlayers = players.stream().filter(pla -> pla.getAmount() == maxAmount)
				.collect(Collectors.toList());
		System.out.println("the no of players who sold for " + maxAmount + " was " + maxPaidPlayers.size());
		return maxPaidPlayers;
	}

	@Override
	public List<Player> getMaxPaidPlayers(String team) {
		List<Player> maxPaidPlayerByTeam = players.stream().filter(pla -> pla.getTeam().equalsIgnoreCase(team))
				.collect(Collectors.toList());
		double maxAmount = maxAmount(maxPaidPlayerByTeam);
		List<Player> maxPaidPlayersByTeam1 = maxPaidPlayerByTeam.stream().filter(pla -> pla.getAmount() == maxAmount)
				.collect(Collectors.toList());
		System.out.println(
				" the no of players from " + team + " sold max of " + maxAmount + " was " + maxPaidPlayerByTeam.size());
		return maxPaidPlayersByTeam1;
	}

	@Override
	public List<Player> getMaxPaidPlayers(String team, String role) {
		List<Player> maxPaidPlayerByTeamAndRole = players.stream().filter(pla -> pla.getRole().equalsIgnoreCase(role))
				.filter(pla -> pla.getTeam().equalsIgnoreCase(team)).collect(Collectors.toList());
		double maxAmount = maxAmount(maxPaidPlayerByTeamAndRole);
		List<Player> maxPaidPlayersByTeamAndRole1 = maxPaidPlayerByTeamAndRole.stream()
				.filter(pla -> pla.getAmount() == maxAmount).collect(Collectors.toList());
		System.out.println(" the no of players from " + team + " of role " + role + " sold max of " + maxAmount
				+ " was " + maxPaidPlayersByTeamAndRole1.size());
		return maxPaidPlayersByTeamAndRole1;
	}

	@Override
	public List<String> getCountryNames() {
		Set<String> countrySet = players.stream().map(ele -> ele.getCountry()).collect(Collectors.toSet());
		System.out.println("total no of countries are " + countrySet.size());
		System.out.println(countrySet);
		List<String> countryList = new ArrayList<String>(countrySet);
		return countryList;
	}

	@Override
	public List<CountryStatsDto> getPlayerCountryStats() {
		List<String> countries = getCountryNames();
		List<CountryStatsDto> countryStatsList = new ArrayList<>();
		for (String countr : countries) {
			List<Player> plaList = players.stream().filter(pla -> pla.getCountry().equals(countr))
					.collect(Collectors.toList());
			String country = countr;
			int playerCount = plaList.size();
			double maxAmount = maxAmount(plaList);
			double minAmount = minAmount(plaList);
			double total = plaList.stream().mapToDouble(p -> p.getAmount()).sum();
			CountryStatsDto csd = CountryStatsDto.builder().country(country).playerCount(playerCount)
					.maxAmount(maxAmount).minAmount(minAmount).totalAmount(total).build();
			countryStatsList.add(csd);
		}
		System.out.println(countryStatsList);
		return countryStatsList;
	}

	private double maxAmount(List<Player> pList) {
		double maxAmt = 0.0;
		for (Player p : pList) {
			if (p.getAmount() > maxAmt) {
				maxAmt = p.getAmount();
			}
		}
		return maxAmt;
	}

	private double minAmount(List<Player> pList) {
		double minAmt = 0.0;
		for (Player p : pList) {
			if (p.getAmount() < minAmt) {
				minAmt = p.getAmount();
			}
		}
		return minAmt;
	}
}
