package org.home.prac.java8;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstStream {

	public static void main(String[] args) {
		Stream<String> nums = Stream.of("one", "two", "three", "four", "five");
		
		Predicate<String> p1 = s -> s.length() > 3;
		
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("four");
		
		// Commenting as cannot run stream more than once
		//nums.filter(p1).forEach(System.out::println);
		
		nums.filter(p2.or(p3)).forEach(System.out::println);
	}
}
