package com.lwl.sc.di.scope;

import jakarta.inject.Provider;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
class AccountService{


//  @Autowired
//  private ObjectFactory<AccountDao> accountDaoFactory;
//
//  public AccountDao getAccountDao() {
//    return accountDaoFactory.getObject();
//  }
  // Lookup

//  private AccountDao accountDao;
//  @Lookup
//  public AccountDao getAccountDao(){
//      return null;
//  }
  @Autowired
  private Provider<AccountDao> accountDaoProvider;

  public AccountDao getAccountDao(){
    return accountDaoProvider.get();
  }


}
@Component
@Scope("prototype")
class AccountDao{

}
@ComponentScan("com.lwl.sc.di.scope")
public class SingleTonWithPrototypeBean {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(SingleTonWithPrototypeBean.class);
    AccountService obj = context.getBean(AccountService.class);
    System.out.println(obj.getAccountDao());
    System.out.println(obj.getAccountDao());
    System.out.println(obj.getAccountDao());
  }
}
