package com.lwl.capp.contact;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class FileUtils {
	ObjectMapper mapper = new ObjectMapper();
	public int writeContactToJSON(List<Contact> list)  {
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			System.out.println(mapper.writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int writeContactCSV(List<Contact> list) {
		System.out.println("id"+','+"name"+','+"email"+','+"mobile"+','+"dob");
		for (Contact contact : list) {
			String con = contact.getId()+","+contact.getName()+","+contact.getEmail()+","+contact.getMobile()+","+contact.getDob();
			System.out.println(con);
		}
		return 0;		
	}
	public List<Contact> readContactsFromJSON(){
		
		return null;		
	}
	public List<Contact> readContactsFromCSV(){
		
		return null;
	}
}
