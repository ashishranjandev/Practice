package org.home.prac.design.adapter;

public class StudentFromLdap {

	private Integer id;
	
	private String name;
	
	private String surName;
	
	private String mail;
	
	public StudentFromLdap(Integer id, String name, String surName, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.mail = mail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
