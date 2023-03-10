package com.lwl.learning.jdbc.dao;

public final class IplStatQueries {

    public static final String TOP_PAID_PLAYERS_OF_EACH_TEAM=
        """
            select t.id,t.name,t.role,t.amount,t.country,t.team
                 from
                  	  (select id,name,role,amount,country,team,dense_rank() 
                  	  over(partition by team order by amount desc) as rn from player) t
                 where t.rn=1 order by team;    
         """;
    public static final String PLAYER_OF_GIVEN_TEAM=
        """
            select id,name,country,role,team,amount from player WHERE lower(country)= lower(?)
        """;
    public static final String ADD_PLAYER=
        """
            insert into player(name,role,country,team,amount) values(?,?,?,?,?);
        """;
    private IplStatQueries(){

    }
}
