package com.lwl.sc.di.ws;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class JsonReaderUtil {
  @SneakyThrows
    public <T> T getData(String fileName, TypeReference<T> cls){
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.registerModule(new JSR310Module());
      return objectMapper.readValue(JsonReaderUtil.class.getResourceAsStream(fileName),cls);
    }
}
