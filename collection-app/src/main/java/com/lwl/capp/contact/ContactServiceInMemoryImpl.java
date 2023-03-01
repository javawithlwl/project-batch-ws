package com.lwl.capp.contact;

import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactServiceInMemoryImpl implements ContactServices {
	FileUtils utils = new FileUtils();
	List<Contact> contactList = new ArrayList<>();

	@Override
	public Contact addContact(Contact contact) {
		contactList.add(contact);
		return contact;
	}

	@Override
	public List<Contact> getContacts() {
		return contactList;
	}

	@Override
	public List<Contact> search(String str) {
		List<Contact> listBySearch = contactList.stream()
				.filter(cl -> cl.getName().contains(str) || cl.getEmail().contains(str)).collect(Collectors.toList());
		return listBySearch;
	}

	@Override
	public Contact updateContact(Contact contact) {
		Optional<Contact> ci = contactList.stream().filter(c->
				c.getId()==contact.getId()||
				c.getName().equals(contact.getName())||
				c.getEmail().equals(contact.getEmail())||
				c.getMobile()==contact.getMobile()||
				c.getDob().equals(contact.getDob())).findFirst();
		int p = contactList.indexOf(ci.orElse(null));
		contactList.set(p, contact);
		return contact;
	}

	@Override
	public boolean deleteContact(int id) {
		Optional<Contact> c1 = contactList.stream().filter(c -> c.getId() == id).findAny();
		boolean flag = contactList.remove(c1.orElse(null));
		return flag;
	}

	@Override
	public Contact getContact(int id) {
		Optional<Contact> c1 = contactList.stream().filter(c -> c.getId() == id).findAny();
		return c1.orElse(null);
	}

	@Override
	public void exportContact(FileType type) {
		if(type.equals(FileType.JSON))
		utils.writeContactToJSON(contactList);
		else
		utils.writeContactCSV(contactList);
	}
	@Override
	public void importContact(FileType type, Path path) {
	System.out.println("not implemented");
	}

	public Map<Integer, String> showMenu() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "add contact");
		map.put(2, "get all contacts");
		map.put(3, "search by name");
		map.put(4, "update contact");
		map.put(5, "delete contact by id");
		map.put(6, "get contact by id");
		map.put(7, "export contacts to json/csv");
		map.put(8, "import contacts from json/csv");
		return map;
	}

	public Contact createContact() throws ParseException {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int id = r.nextInt();
		System.out.print("enter name :");
		String name = s.next();
		System.out.print("enter email :");
		String email = s.next();
		System.out.print("enter mobile number :");
		long mobile = s.nextLong();
		System.out.print("enter dob :");
		String dob = s.next();
		return new Contact(id, name, email, mobile, dob);
	}

	public List<Integer> getAllIds() {
		List<Integer> idlist = contactList.stream().map(c -> c.getId()).collect(Collectors.toList());
		return idlist;
	}
}
