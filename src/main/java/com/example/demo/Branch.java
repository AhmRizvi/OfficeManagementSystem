package com.example.demo;

public class Branch {
	int branchcode;
	String branchname;
	String address;
	String city;
	String country;
	String status;
	
	

	public Branch(int branchcode, String branchname, String address, String city, String country, String status) {
		super();
		this.branchcode = branchcode;
		this.branchname = branchname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.status = status;
	}
	
	
	

	public Branch(int branchcode, String status) {
		super();
		this.branchcode = branchcode;
		this.status = status;
	}




	public Branch(int branchcode, String branchname, String address, String city, String country) {
		super();
		this.branchcode = branchcode;
		this.branchname = branchname;
		this.address = address;
		this.city = city;
		this.country = country;
	}




	public Branch() {
		super();
	}

	public int getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(int branchcode) {
		this.branchcode = branchcode;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
