package com.lwl.sc.di.xml;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class ContactDaoImpl implements  ContactDao{

  @Autowired
  private ConnectionService connectionService;

  @Override
  public List<Contact> getContact() {

    Connection con = connectionService.getConnection();
    Statement st = null;
    ResultSet rs = null;
    List<Contact> list = new ArrayList<>();
    try{
      st = con.createStatement();
      rs = st.executeQuery("select id,full_name,email,mobile from contact");
      while(rs.next()){
          Contact contact = new Contact();
          contact.setId(rs.getInt("id"));
          contact.setName(rs.getString("full_name"));
          contact.setEmail(rs.getString("email"));
          contact.setMobile(rs.getString("mobile"));
          list.add(contact);
      }
    }catch (SQLException e){
        e.printStackTrace();
    }
    return list;
  }
}
