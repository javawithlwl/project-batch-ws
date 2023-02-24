package com.lwl.capp.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lwl.capp.playerstats.CsvReaderUtil;
import com.lwl.capp.playerstats.Player;
import lombok.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Employee {
  private int empno;
  private String name;
  private double salary;
}

public class JsonUtil {

  public static void main(String[] args) throws IOException {

    String jsonStr = """
        {
          "empno": 1001,
          "name": "Krish",
          "salary": 98000
        }
        """;
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    Employee emp = objectMapper.readValue(jsonStr, Employee.class);
    System.out.println(emp);
    String empJsonStr = objectMapper.writeValueAsString(emp);
    System.out.println(empJsonStr);

    List<Player> list = CsvReaderUtil.loadDataFromCsv();
    objectMapper.writeValue(new File("players.json"),list);
  }
}
