package com.lwl.capp.playerstats;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {
  private String name;
  private String role;
  private double amount;
  private String country;
  private String team;
}
