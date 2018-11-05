package org.home.prac.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> list2 = Arrays.asList(2, 3, 4);
		List<Integer> list3 = Arrays.asList(3, 5, 7);
		
		List<List<Integer>> list = Arrays.asList(list1, list2, list3);
		System.out.println("List after adding all the list elements : "+list);
		
		// Creating reference of a function which finds size
		Function<List<?>, Integer> size = List::size;
		Function<List<Integer>, Stream<Integer>> flatmapper = inputlist -> inputlist.stream();
		
		list.stream().forEach(System.out::println);
		
		list.stream().map(size).forEach(System.out::println);
		
		System.out.println("Printing FlatMap --");
		list.stream().flatMap(flatmapper).forEach(System.out::println);
		
		
		
	}
}
