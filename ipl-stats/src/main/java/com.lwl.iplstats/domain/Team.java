package com.lwl.iplstats.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    private int id;
    private String name;
    private String captain;
    private String captainImgUrl;

}
