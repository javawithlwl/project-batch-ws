package ipl.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import ipl.domain.Player;
import ipl.domain.Team;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IplServiceUtil {
    public static List<Player> getPlayers(Path path) throws CsvValidationException, IOException {

        List<String[]> list = readFromCSV(path,true);
        List<Player> playersList = new ArrayList<>();
        for(String[] plyr:list){
            Player player = Player.builder()
                    .name(plyr[0])
                    .role(plyr[1])
                    .amount(Double.valueOf(plyr[2]))
                    .country(plyr[3])
                    .team(plyr[4])
                    .build();
            playersList.add(player);
        }
        return playersList;
    }


    public static List<Team> getTeams(Path path) throws CsvValidationException, IOException {

        List<String[]> list = readFromCSV(path,true);
        List<Team> teamList = new ArrayList<>();
        for(String[] team:list){
            Team teames = Team.builder()
                    .Tname(team[0])
                    .team(team[2])
                    .captain(team[2])
                    .build();
            teamList.add(teames);
        }
        return teamList;
    }

    private static List<String[]> readFromCSV(Path filePath, boolean hasHeader) throws IOException, CsvValidationException {
        List<String[]> list = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    list.add(line);
                }
            }
        }
        if (hasHeader) {
            return list.subList(1, list.size());
        }
        return list;
    }

}
