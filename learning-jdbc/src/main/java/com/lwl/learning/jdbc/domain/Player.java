package com.lwl.learning.jdbc.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {

    private int id;
    private String name;
    private String role;
    private String team;
    private String country;
    private double amount;
}
