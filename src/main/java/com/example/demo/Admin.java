package com.example.demo;

public class Admin {

	int id;
	String password;
	
	
	public Admin() {
		super();
	}


	public Admin(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
