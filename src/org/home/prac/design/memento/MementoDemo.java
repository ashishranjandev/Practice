package org.home.prac.design.memento;

public class MementoDemo {
	
	public static void main(String[] args) {
		CareTaker careTaker = new CareTaker();
		Employee emp = new Employee();
		
		emp.setName("Amit Kumar");
		emp.setAddress("221B Street");
		emp.setPhoneNumber("888-556-1414");
		
		System.out.println("Employee before Save  "+emp);
		careTaker.save(emp);
		
		emp.setPhoneNumber("812-444-1515");
		careTaker.save(emp);

		System.out.println("Employee after Save  "+emp);
		emp.setPhoneNumber("812-444-1516");
		careTaker.revert(emp);
		System.out.println("Employee after revert "+emp);
	}
	
}