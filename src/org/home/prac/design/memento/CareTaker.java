package org.home.prac.design.memento;

import java.util.Stack;

public class CareTaker {

	private Stack<Employee> employeeHistory = new Stack<>();
	
	public void save(Employee employee) {
		employeeHistory.push(employee);
	}
	
	public void revert(Employee employee) {
		employee.revert(employeeHistory.pop());
	}
}
