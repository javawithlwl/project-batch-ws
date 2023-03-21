package com.lwl.sc.di.xml;

import com.lwl.common.util.AwsS3Service;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class ContactServiceImpl implements  ContactService {

  private ContactDao contactDao;

  private AwsS3Service awsS3Service;
  @Autowired
  public ContactServiceImpl(ContactDao contactDao,AwsS3Service awsS3Service){
      this.contactDao = contactDao;
  }
  @Override
  public List<Contact> getContact() {
    return contactDao.getContact();
  }
}
