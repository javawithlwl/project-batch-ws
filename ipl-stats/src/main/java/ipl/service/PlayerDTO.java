package ipl.service;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString

public class PlayerDTO {
    public String Pname;
    public String Tname;
    public String role;
    public String country;
    public String team;
    public double amount;
    Set<String> names = new HashSet<>();
    public int count;
}
