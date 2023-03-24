package com.lwl.sc.di.pms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
class PlayerService{
    private PlayerDao playerDao;
    @Autowired
    public PlayerService(PlayerDao playerDao){
        this.playerDao = playerDao;
    }

//    public void setPlayerDao(PlayerDao playerDao){
//        this.playerDao = playerDao;
//    }
    public String getPlayerCount(){
        return String.format("Player count is %s",playerDao.getCount());
    }
}

class PlayerDao{
    public int getCount(){
      return 243;
    }
}


@ComponentScan("com.lwl.sc.di.pms")
public class SampleManager {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(SampleManager.class);
    PlayerService playerService = context.getBean(PlayerService.class);
    //System.out.println(playerService.getPlayerCount());
  }
}
