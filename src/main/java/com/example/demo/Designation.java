package com.example.demo;

public class Designation {
	int designationid;
	String designationname;

	public Designation(int designationid, String designationname) {
		super();
		this.designationid = designationid;
		this.designationname = designationname;
	}

	public Designation() {
		super();
	}

	public int getDesignationid() {
		return designationid;
	}

	public void setDesignationid(int designationid) {
		this.designationid = designationid;
	}

	public String getDesignationname() {
		return designationname;
	}

	public void setDesignationname(String designationname) {
		this.designationname = designationname;
	}

}
