package com.lwl.sc.di.ws;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Transactions {

      private Long id;
      @JsonProperty("date")
      @JsonFormat(pattern = "dd-MM-yyyy")
      private LocalDate date;
      @JsonProperty("from_mobile")
      private String fromMobile;
      @JsonProperty("to_mobile")
      private String toMobile;
      private double amount;
}
