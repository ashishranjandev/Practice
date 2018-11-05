package org.home.prac.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionOptionalExample {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 10, -10);
		
		Integer maxValue = list.stream().reduce(0, Integer::max);
		System.out.println("Max Value is "+maxValue);
		
		Optional<Integer> maxValueOptional = list.stream().reduce(Integer::max);
		if(maxValueOptional.isPresent()) {
			System.out.println("Max Value is "+maxValueOptional.get());
		} else {
			System.out.println("Max Value is not present");
		}		
		
		Integer minValue = list.stream().reduce(0, Integer::min);
		System.out.println("Min Value is "+minValue);
		
		Optional<Integer> minValueOptional = list.stream().reduce(Integer::min);
		if(minValueOptional.isPresent()) {
			System.out.println("Min Value is "+minValueOptional.get());
		} else {
			System.out.println("Min Value is not present");
		}
	}
}
