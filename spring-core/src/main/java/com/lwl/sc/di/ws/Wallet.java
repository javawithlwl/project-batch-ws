package com.lwl.sc.di.ws;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDate;

@Data
public class Wallet {

    private long id;
    @JsonProperty("created_date")
    private LocalDate createdDate;
    private String mobile;
    private double balance;

}
