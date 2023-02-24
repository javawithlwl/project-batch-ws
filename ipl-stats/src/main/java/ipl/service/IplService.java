package ipl.service;

import ipl.domain.Player;

import java.util.List;
import java.util.Set;

public interface IplService {

    List<PlayerDTO>  getPlayerNames() ;
    List<PlayerDTO>  getTeamNames();
    Set<PlayerDTO>  getCountryNames();
    List<PlayerDTO> getPlayersOfTeam(String team);
    List<PlayerDTO> getPlayersOfRole(String roleName);
    Set<PlayerDTO> getPlayersOfCountry(String countryName);
    //List<Player> getMaxpayedPlayers();
    List<PlayerDTO> getMaxpayedPlayer();
    List<Player> getMaxPayedPlayerOfRole(String roleName);
    List<Player> getMaxpayedPlayerOfTeam(String teamName);
    List<Player> getMaxGetPlayerOfTeamRole(String team, String role);

}
