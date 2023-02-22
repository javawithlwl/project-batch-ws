package com.lwl.capp.playerstats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamStatsDto {
    private String team;
    private int playerCount;
    private double totalAmount;
}
