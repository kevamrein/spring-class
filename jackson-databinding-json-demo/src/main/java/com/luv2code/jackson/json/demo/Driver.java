package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Student student = objectMapper.readValue(new File("data/sample-lite.json"), Student.class);
			
			System.out.println(student.getFirstName());
			System.out.println(student.getLastName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
