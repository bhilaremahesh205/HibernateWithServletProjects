package com.javatpoint;

public class Student {
	
	private String name;

	public String getName() {
		System.out.println("Student - getName method called..");
		return name;
	}

	public void setName(String name) {
		//System.out.println("Student - setName method called..");
		this.name = name;
	}

	public void displayInfo() {
		System.out.println("Hello: " + name);
	}
}
