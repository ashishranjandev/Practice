package org.home.prac.design.adapter;

public class StudentFromDB implements Student {
	
	private Integer rollNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	public StudentFromDB(Integer rollNumber, String firstName, String lastName, String emailId) {
		super();
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	
	@Override
	public String toString() {
		return "StudentFromDB [rollNumber=" + rollNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + "]";
	}



	public Integer getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
