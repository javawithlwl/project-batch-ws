package com.lwl.sc.di.xml;

import com.lwl.common.util.AwsS3Service;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@Setter
@PropertySource("classpath:/application.properties")
public class AppConfig {

  @Value("${db.url}")
  private String url;
  @Value("${db.username}")
  private String username;
  @Value("${db.password}")
  private String password;


//  @Bean
//  public ContactController contactController(){
//      ContactController obj = new ContactController();
//      obj.setContactService(contactService());
//      return obj;
//  }
//
//  @Bean
//  public ContactService contactService(){
//      ContactServiceImpl contactService = new ContactServiceImpl();
//      contactService.setContactDao(contactDao());
//      return contactService;
//  }
//
//  @Bean
//  public ContactDao contactDao(){
//      ContactDaoImpl obj = new ContactDaoImpl();
//      obj.setConnectionService(connectionService());
//      return obj;
//  }

  @Bean
  public ConnectionService connectionService() {
    ConnectionServiceImpl obj = new ConnectionServiceImpl();
    obj.setUrl(url);
    obj.setUsername(username);
    obj.setPassword(password);
    return obj;
  }
  @Bean
  public AwsS3Service awsS3Service(){
      AwsS3Service obj = new AwsS3Service();
      return obj;
  }
}
