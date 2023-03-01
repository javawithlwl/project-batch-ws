package com.lwl.capp.contact;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {
	private int id;
	private String name;
	private String email;
	private long mobile;
	private String dob;
}
