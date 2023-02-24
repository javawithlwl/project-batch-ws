package ipl.domain;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Player {
    public String name;
    public String role;
    public Double amount;
    public String country;
    public String team;


}
