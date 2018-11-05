package org.home.prac.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermeditaryAndFinal {

	public static void main(String[] args) {
		Stream<String> nums = Stream.of("one", "two", "three", "four", "five");
		
		Predicate<String> p1 = s -> s.length() > 3;
		
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("four");
		
		List<String> list = new ArrayList<>();
		
		nums.peek(System.out::println).filter(p1.or(p2)).peek(list::add);
		
		// Size of list will be zero as no final operation done on stream
		// stream is just declaration of data, It does not hold any data.
		System.out.println("Size of the List: "+list.size());
	}

}
