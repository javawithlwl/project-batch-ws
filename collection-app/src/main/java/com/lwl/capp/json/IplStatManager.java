package com.lwl.capp.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.apache.commons.collections4.functors.ForClosure;

import com.lwl.capp.playerstats.CsvReaderUtil;
import com.lwl.capp.playerstats.Player;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@data
class Player1{
	private String name;
	private String country;
	private double amount;
}

class Role{
	private String role;
	private List<Player1> players1;
}

class Teams{
	private String team;
	private List<Role> roles;
}

class JsonEx{
	private Teams t;
}

public class IplStatManager {
	
	public static void main(String[] args) {
	List<Player> players = CsvReaderUtil.loadDataFromCsv();
	Set<String> teams1 = players.stream().map(p->p.getTeam()).collect(Collectors.toSet());
	Map<String,List<Player1>> teams11 = new HashMap<String, List<Player1>>();
	//for (String  : teams1) {
		
	}
	
	
	}
		

