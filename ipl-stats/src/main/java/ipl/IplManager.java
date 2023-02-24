package ipl;

import ipl.domain.Player;
import ipl.service.IplService;
import ipl.service.IplServiceImpl;
import ipl.service.PlayerDTO;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class IplManager {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)  {

        IplService iplService = new IplServiceImpl();
        while (true) {
            System.out.println("-".repeat(100));

            System.out.println("Select the service option 1. Get all player names  2. Get all team names    3. Get all country names    4. Get players list in given team " +
                    " 5.Get players list of given role    6. Get players list of given Country name    7. Get max Paid players   8.  Get max paid players of given Role " +
                    "   9.Get max get player by team  10. Get max payed played of given team and role  11.Exit");
            System.out.printf("Enter your option : ");
            Integer option = sc.nextInt();
            switch (option) {
                case 1:
                    List<PlayerDTO> playerss = iplService.getPlayerNames();
                    int count = 1;
                    for (PlayerDTO plDTO : playerss) {
                        System.out.println(count + ")" + plDTO.getPname());
                        count++;
                    }
                    break;
                case 2:
                    List<PlayerDTO> teamss = iplService.getTeamNames();
                    int counts = 1;
                    for (PlayerDTO tmDTO : teamss) {
                        System.out.println(counts + ") " + tmDTO.getTname());
                        counts++;
                    }
                    //  10
                    break;
                case 3:
                    Set<PlayerDTO> countries = iplService.getCountryNames();
                    int num = 1;
                    for (PlayerDTO plDTO : countries) {
                        System.out.println(num + ")" + plDTO.getCountry());
                        num++;
                    }
                    break;
                case 4:
                    System.out.printf("Enter team name : ");
                    sc.nextLine();
                    String teamName = sc.nextLine();
                    List<PlayerDTO> players = iplService.getPlayersOfTeam(teamName);
                    for (PlayerDTO plDTO : players) {
                        System.out.println("Given Team " + teamName + " has Players :" + plDTO.getNames() + " ");
                        break;
                    }
                    break;
                case 5:
                    System.out.printf("Enter role : ");
                    sc.nextLine();
                    String roleName = sc.nextLine();
                    List<PlayerDTO> roleOfPlayers = iplService.getPlayersOfRole(roleName);
                    for (PlayerDTO plDTO : roleOfPlayers) {
                        System.out.println("Given Role " + roleName + " are :" + plDTO.getNames() + " ");
                        break;
                    }
                    break;
                case 6:
                    System.out.printf("Enter country name : ");
                    sc.nextLine();
                    String countryName = sc.nextLine();
                    Set<PlayerDTO> playersOfCountry = iplService.getPlayersOfCountry(countryName);
                    for (PlayerDTO plDTO : playersOfCountry) {
                        System.out.println("Given Country " + countryName + " has Players :" + plDTO.getNames());
                        break;
                    }
                    break;
                case 7:
                    List<PlayerDTO> maxPayedAmount = iplService.getMaxpayedPlayer();
                    for (PlayerDTO plDTO : maxPayedAmount) {
                        System.out.println("Player " + plDTO.getPname() + "--- getting max amount of : " + plDTO.getAmount());
                        break;
                    }
                    break;
                /*       OR
                List<Player> maxPayedAmount =  iplService.getMaxpayedPlayers();
                for (Player plDTO:maxPayedAmount){
                    System.out.println("Player "+plDTO.getName()+"--- getting max amount of : "+plDTO.getAmount()) ;
                    break;
                }
                break;*/
                case 8:
                    System.out.printf("Enter role : ");
                    sc.nextLine();
                    String role = sc.nextLine();
                    List<Player> maxPayedPlOfRole = iplService.getMaxPayedPlayerOfRole(role);
                    for (Player plDTO : maxPayedPlOfRole) {
                        System.out.println("Player " + plDTO.getName() + "  Role of ; " + plDTO.getRole()
                                + " ----  getting max amount of : " + plDTO.getAmount());
                        break;
                    }
                    break;

                case 9:
                    System.out.printf("Enter team : ");
                    sc.nextLine();
                    String team = sc.nextLine();
                    List<Player> maxPayedPlOfTeam = iplService.getMaxpayedPlayerOfTeam(team);
                    for (Player plDTO : maxPayedPlOfTeam) {
                        System.out.println("Player " + plDTO.getName() + " Team of : " + plDTO.getTeam()
                                + " ----  getting max amount of : " + plDTO.getAmount());
                        break;
                    }
                    break;
                case 10:
                    System.out.printf("Enter team : ");
                    sc.nextLine();
                    String teamN = sc.nextLine();
                    System.out.printf("Enter role : ");
                    String roleNa = sc.nextLine();

                    List<Player> maxGetPlayr = iplService.getMaxGetPlayerOfTeamRole(teamN, roleNa);
                    for (Player plDTO : maxGetPlayr) {
                        System.out.println("Player " + plDTO.getName() + " Team of : " + plDTO.getTeam()
                                + " ----  getting max amount of : " + plDTO.getAmount());
                        break;
                    }
                case 11:
                    System.out.println("Thank You");
                    System.exit(0);
                default:
                    System.out.println("Please Enter Valid Option");
            }
        }

    }


}
