package com.lwl.capp.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {
	private int id;
	private String name;
	private String email;
	private long mobile;
	private String dob;
}
