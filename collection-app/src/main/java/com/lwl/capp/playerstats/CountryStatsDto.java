package com.lwl.capp.playerstats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryStatsDto {

    private String country;
    private int playerCount;
    private double maxAmount;
    private double minAmount;
    private double totalAmount;
}
