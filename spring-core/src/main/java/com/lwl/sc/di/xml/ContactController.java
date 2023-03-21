package com.lwl.sc.di.xml;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Getter
@Setter
@Controller
public class ContactController {
      @Autowired
      private ContactService contactService;

      public List<Contact> getContacts(){
          return contactService.getContact();
      }
}
