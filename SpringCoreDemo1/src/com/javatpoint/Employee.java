package com.javatpoint;

public class Employee {
	private int id;
	private String name;

	public Employee() {
		System.out.println("Employee() : Default constructor");
		id = 111;
		name = "default-value";
	}

	public Employee(int id) {
		System.out.println("Employee(int id) : constructor");
		this.id = id;
	}

	public Employee(String name) {
		System.out.println("Employee(String name) : constructor");
		this.name = name;
	}

	public Employee(int id, String name) {
		System.out.println("Employee(int id, String name) : constructor");
		this.id = id;
		this.name = name;
	}

	public Employee(Employee emp) {
		System.out.println("Employee(Employee emp) : constructor");
		this.name = emp.name;
		this.id = emp.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void display(String objRefName) {
		System.out.println("objRefName : " + objRefName + " id : " + id + " name : " + name);
	}

}
