package com.lwl.capp.contact;

import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ContactManager {

	public static void main(String[] args) throws ParseException {
		ContactServiceInMemoryImpl impl = new ContactServiceInMemoryImpl();
		Map<Integer, String> menu = new HashMap<>();
		menu = impl.showMenu();
		Collection<Entry<Integer, String>> keys = menu.entrySet();
		char ch;
		do {
			System.out.println();
			for (Entry<Integer, String> entry : keys) {
				System.out.println(entry);
			}
			System.out.println();
			Scanner s = new Scanner(System.in);
			System.out.println("enter your response in number");
			int res = s.nextInt();
			switch (res) {
			case 1:
				Contact c11 = impl.createContact();
				Contact c111 = impl.addContact(c11);
				System.out.println(c111);
				break;
			case 2:
				List<Contact> contactList1 = impl.getContacts();
				System.out.println(contactList1);
				break;
			case 3:
				System.out.println("enter string to search in contacts :");
				String scl = s.next();
				List<Contact> contactListByserch = impl.search(scl);
				System.out.println(contactListByserch);
				break;
			case 4:
				Contact c12 = impl.createContact();
				Contact c112 = impl.updateContact(c12);
				System.out.println(c112);
				break;
			case 5:
				List<Integer> ids = impl.getAllIds();
				System.out.println(ids);
				System.out.println("enter the id to delete contact");
				int del = s.nextInt();
				boolean flag = impl.deleteContact(del);
				if (flag)
					System.out.println("contact deleted sucessfully");
				else
					System.out.println("contact not deleted");
				break;
			case 6:
				List<Integer> idss = impl.getAllIds();
				System.out.println(idss);
				System.out.println("enter the id to get contact");
				int get = s.nextInt();
				Contact c1 = impl.getContact(get);
				System.out.println(c1);
				break;
			case 7:
				System.out.println("enter the type of file to export contact(csv/json) :");
				String type = s.next();
				impl.exportContact(FileType.valueOf(type.toUpperCase()));
				break;
			case 8:
				impl.importContact(null, null);
				break;
			default:
				System.out.println("enter valid response");
				break;
			}
			System.out.println("do you want to continue with one more operation(y/n):");
			ch = s.next().charAt(0);
		} while (ch != 'n');
	}

}
