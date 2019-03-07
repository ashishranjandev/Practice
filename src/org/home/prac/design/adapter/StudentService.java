package org.home.prac.design.adapter;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		
		students.add(new StudentFromDB(1, "Amit", "Kumar", "amit.kumar@mail.com"));
		students.add(new StudentAdapterLdap(new StudentFromLdap(1, "Evan", "Brown", "evan.brown@mail.com")));
		
		System.out.println(students.toString());
	}
}
