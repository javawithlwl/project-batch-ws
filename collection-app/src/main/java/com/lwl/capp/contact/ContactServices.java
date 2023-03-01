package com.lwl.capp.contact;

import java.nio.file.Path;
import java.util.List;

public interface ContactServices {
	Contact addContact(Contact contact);
	List<Contact> getContacts();
	List<Contact> search(String str);
	Contact updateContact(Contact contact);
	boolean deleteContact(int id);
	Contact getContact(int id);
	void exportContact(FileType type);
	void importContact(FileType type, Path path);
}
