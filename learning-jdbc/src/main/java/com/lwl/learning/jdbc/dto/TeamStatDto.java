package com.lwl.learning.jdbc.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TeamStatDto {

    private String team;
    private double totalAmount;
    private double minAmount;
    private double maxAmount;
    private int playerCount;

}
