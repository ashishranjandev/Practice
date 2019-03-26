package org.home.prac.design.memento;

public class Employee {

	private String name;
	
	private String address;
	
	private String phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void revert(Employee employee) {
		this.name = employee.getName();
		this.phoneNumber = employee.getPhoneNumber();
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
