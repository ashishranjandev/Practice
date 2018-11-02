package org.home.prac.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("**", "*", "****", "***", "******");
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return Integer.compare(arg0.length(), arg1.length());
			}
			
		};
		
		Comparator<String> compLambda = (arg0, arg1) -> {
			return Integer.compare(arg0.length(), arg1.length());
		};
		
		Collections.sort(list, compLambda);
		list.forEach(System.out::println);
	}
}
