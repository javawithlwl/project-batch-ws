package ipl.service;

import com.opencsv.exceptions.CsvValidationException;
import ipl.domain.Player;
import ipl.domain.Team;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class IplServiceImpl implements IplService {
    private IplServiceUtil iplServiceUtil;
    private List<Player> players;
    private List<Team> teams;
    private Map<String, List<Player>> mapList;

    public IplServiceImpl() {
        iplServiceUtil = new IplServiceUtil();

        try {
            players = IplServiceUtil.getPlayers(new File(this.getClass().getResource("/players.csv").getFile()).toPath());
            teams = IplServiceUtil.getTeams(new File(this.getClass().getResource("/team.csv").getFile()).toPath());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mapList = players.stream().collect(Collectors.groupingBy(Player::getTeam));


    }

    @Override
    public List<PlayerDTO>  getPlayerNames() {
        List<PlayerDTO> playerList = new ArrayList<>();


        for (Player player : players) {
            String Pname = player.getName();

            PlayerDTO playerDTO = PlayerDTO.builder()
                    .Pname(Pname).build();
            playerList.add(playerDTO);
        }
        return playerList;
    }

    public List<PlayerDTO>  getTeamNames() {
        List<PlayerDTO> teamList = new ArrayList<>();
        try {
            players = IplServiceUtil.getPlayers(new File(this.getClass().getResource("/players.csv").getFile()).toPath());
            teams = IplServiceUtil.getTeams(new File(this.getClass().getResource("/team.csv").getFile()).toPath());

            for (Team player : teams) {
                String Tname = player.getTname();

                PlayerDTO playerDTO = PlayerDTO.builder()
                        .Tname(Tname).build();
                teamList.add(playerDTO);
            }

        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
        return teamList;
    }


    public List<PlayerDTO> getPlayersOfTeam(String teamName)  {

        List<PlayerDTO> playersOfTeam = new ArrayList<>();

        Set<String> names = new HashSet<>();
        for (Player plyr : players) {
            String team = plyr.getTeam();
            String Pname;
            if (team.equalsIgnoreCase(teamName)) {
                Pname = plyr.getName();
                names.add(Pname);

            }
            PlayerDTO playerDTO = PlayerDTO.builder()
                    .names(names)
                    .build();
            playersOfTeam.add(playerDTO);
            }
        return playersOfTeam;

    }

    public List<PlayerDTO> getPlayersOfRole(String roleName)  {

        List<PlayerDTO> playersOfRole = new ArrayList<>();

        Set<String> names = new HashSet<>();
        for (Player plyr : players) {
            String role = plyr.getRole();
            String Pname;
            if (role.equalsIgnoreCase(roleName)) {
                Pname = plyr.getName();
                names.add(Pname);

            }
            PlayerDTO playerDTO = PlayerDTO.builder()
                    .names(names)
                    .build();
            playersOfRole.add(playerDTO);
        }

        return playersOfRole;

    }


    public Set<PlayerDTO> getPlayersOfCountry(String countryName) {
        Set<PlayerDTO> playersOfCountry = new HashSet<>();

        Set<String> names = new HashSet<>();
        for (Player plyr : players) {
            String countryy = plyr.getCountry();
            String country;
            if (countryy.equalsIgnoreCase(countryName)) {
                country = plyr.getName();
                names.add(country);
            }
            PlayerDTO playerDTO = PlayerDTO.builder()
                    .names(names)
                    .build();
            playersOfCountry.add(playerDTO);
        }
        return playersOfCountry;
    }
    /*public List<Player> getMaxpayedPlayers(){
        double maxAmount = getMaxAmount(players);
        List<Player> maxPaidPlayers = players.stream().filter(p -> p.getAmount() == maxAmount).collect(Collectors.toList());
        return maxPaidPlayers;
    }*/     // OR //
    public List<PlayerDTO> getMaxpayedPlayer(){
        List<PlayerDTO> maxPayedPlayer = new ArrayList<>();


        for (Player plyr:players) {
            Double paymentAmount = (double) 0;
            Double amount = plyr.getAmount();
            String Pname = "";
            if (plyr.getAmount() >= paymentAmount) {
                Pname += plyr.getName();
                paymentAmount = amount;
            }else if (amount == paymentAmount) {
                Pname += plyr.getName();
            }
            PlayerDTO playerDTO = PlayerDTO.builder()
                    .Pname(Pname)
                    .amount(amount)
                    .build();
            maxPayedPlayer.add(playerDTO);
        }

        return maxPayedPlayer;
    }


    public List<Player> getMaxPayedPlayerOfRole(String roleName){

        Map<String, List<Player>> map = players.stream().collect(Collectors.groupingBy(Player::getRole));
        List<Player> playerOf = map.get(roleName);
        double maxAmount = getMaxAmount(playerOf);

        List<Player> getMax = players.stream().filter(ele-> ele.getAmount() == maxAmount).collect(Collectors.toList());
        return getMax;
    }

    public Set<PlayerDTO>  getCountryNames() {
        Set<PlayerDTO> countryList = new HashSet<>();

        for (Player player : players) {
            String country = player.getCountry();

            PlayerDTO playerDTO = PlayerDTO.builder()
                    .country(country).build();
            countryList.add(playerDTO);
        }
        return countryList;
    }


    public List<Player> getMaxpayedPlayerOfTeam(String teamName){

        List<Player> playerOf = mapList.get(teamName.toUpperCase());
        double maxAmountOf = getMaxAmount(playerOf);
        List<Player> getMax = playerOf.stream().filter(ele-> ele.getAmount() == maxAmountOf).collect(Collectors.toList());

        return getMax;
        }


    public List<Player> getMaxGetPlayerOfTeamRole(String team, String role){
        List<Player> players = mapList.get(team);

        List<Player> playersByRoleList = players.stream().filter(p -> p.getRole().equals(role)).collect(Collectors.toList());
        double maxAmount = getMaxAmount(playersByRoleList);
        List<Player> maxPaidPlayers = playersByRoleList.stream().filter(p -> p.getAmount() == maxAmount).collect(Collectors.toList());

        return maxPaidPlayers;
    }

    private double getMaxAmount(List<Player> list){
        double maxAmount = list.get(0).getAmount();
        for (Player player:list){
            double amount = player.getAmount();
            if (amount > maxAmount){
                maxAmount = amount;
            }
        }
        return maxAmount;
    }

}
