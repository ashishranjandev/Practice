package org.home.prac.java8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergingMaps {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		try {
			BufferedReader reader = 
					new BufferedReader(
							new InputStreamReader(
									MergingMaps.class.getResourceAsStream("people.txt")));
			Stream<String> stream = reader.lines();
			stream.map(line -> {
				String[] s = line.split(" ");
				Person person = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2]);
				persons.add(person);
				return person;
			}).forEach(System.out::println);
			
			List<Person> list1 = persons.subList(0, 5);
			List<Person> list2 = persons.subList(5, persons.size());
			
			Map<Integer, List<Person>> map1 = mapByAge(list1);
			System.out.println("********** MAP1 ****************");
			map1.forEach((age, person) -> {
				System.out.println("Age is - "+age+ " Person is "+person);
			});
			
			Map<Integer, List<Person>> map2 = mapByAge(list2);
			System.out.println("********** MAP2 ****************");
			map2.forEach((age, person) -> {
				System.out.println("Age is - "+age+ " Person is "+person);
			});
			
			//Merging entries of map2 to map1
			map2.entrySet().stream().forEach( entrySet -> {
				map1.merge(entrySet.getKey(), entrySet.getValue(), (l1, l2) -> {
					l1.addAll(l2);
					return l1;
				});
			});
			
			System.out.println("********** MAP1 After Merge****************");
			map1.forEach((age, person) -> {
				System.out.println("Age is - "+age+ " Person is "+person);
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Map<Integer, List<Person>> mapByAge(List<Person> list) {
		Map<Integer, List<Person>> map = 
				list.stream().collect(Collectors.groupingBy(Person::getAge));
		return map;
	}

}
