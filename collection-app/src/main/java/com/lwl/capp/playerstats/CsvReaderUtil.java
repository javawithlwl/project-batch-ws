package com.lwl.capp.playerstats;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public final class CsvReaderUtil {

  private CsvReaderUtil() {

  }

  @SneakyThrows
  public static List<Player> loadDataFromCsv() {
    Reader in = new FileReader(new File(CsvReaderUtil.class.getResource("/players.csv").getFile()));
    String[] HEADERS = "name,role,amount,country,team".split(",");
    List<Player> playerList = new ArrayList<>();
    Iterable<CSVRecord> records = CSVFormat.DEFAULT
        .withHeader(HEADERS)
        .withFirstRecordAsHeader()
        .parse(in);
    for (CSVRecord record : records) {
      String name = record.get("name");
      String role = record.get("role");
      double amount = Double.parseDouble(record.get("amount"));
      String country = record.get("country");
      String team = record.get("team");
      Player player = Player.builder()
          .name(name)
          .role(role)
          .amount(amount)
          .country(country)
          .team(team)
          .build();
      playerList.add(player);
    }
    return playerList;
  }

}

