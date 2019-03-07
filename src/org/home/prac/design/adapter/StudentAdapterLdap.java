package org.home.prac.design.adapter;

public class StudentAdapterLdap implements Student {

	private StudentFromLdap instance;
	
	public StudentAdapterLdap(StudentFromLdap studentFromLdap) {
		this.instance = studentFromLdap;
	}
	
	@Override
	public Integer getRollNumber() {
		return this.instance.getId();
	}

	@Override
	public String getFirstName() {
		return this.instance.getName();
	}

	@Override
	public String getEmailId() {
		return this.instance.getMail();
	}

	@Override
	public String getLastName() {
		return this.instance.getSurName();
	}

	@Override
	public String toString() {
		return "StudentAdapterLdap [instance=" + instance.getId() + "]";
	}
	
	
}
