package com.lwl.capp.contact;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
public class FileUtils {
	ObjectMapper mapper = new ObjectMapper();

	public void writeContactToJSON(List<Contact> list) {
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			mapper.writeValue(new File("contact.json"), list);
			System.out.println(mapper.writeValueAsString(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeContactCSV(List<Contact> list) {
		try {
			CSVPrinter cp = new CSVPrinter(new FileWriter("contact123.csv"), CSVFormat.DEFAULT);
			cp.printRecord("id", "name", "email", "mobile", "dob");
			for (Contact c : list) {
				cp.printRecord(c.getId(), c.getName(), c.getEmail(), c.getMobile(), c.getDob());
			}
			cp.flush();
			cp.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Contact> readContactsFromJSON() {
		System.out.println("not implemented");
		return null;
	}

	public List<Contact> readContactsFromCSV() {
		List<Contact> conList = new ArrayList<>();
		try {
			Reader in = new FileReader(new File(FileUtils.class.getResource("/contact123.csv").getFile()));
			String[] HEADERS = "id,name,email,mobile,dob".split(",");
			Iterable<CSVRecord> records;
			try {
				records = CSVFormat.DEFAULT.withHeader(HEADERS).withFirstRecordAsHeader().parse(in);
				for (CSVRecord record : records) {
					int id = Integer.parseInt(record.get("id"));
					String name = record.get("name");
					String email = record.get("email");
					long mobile = Long.parseLong(record.get("mobile"));
					String dob = record.get("dob");
					Contact contact = new Contact(id, name, email, mobile, dob);
					conList.add(contact);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return conList;
	}
}
