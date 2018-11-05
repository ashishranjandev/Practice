package org.home.prac.java8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BuildingBiMaps {
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		try {
			BufferedReader reader = 
					new BufferedReader(
							new InputStreamReader(
									BuildingBiMaps.class.getResourceAsStream("people.txt")));
			Stream<String> stream = reader.lines();
			stream.map(line -> {
				String[] s = line.split(" ");
				Person person = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2]);
				persons.add(person);
				return person;
			}).forEach(System.out::println);
			
			// Creating a BiMap where Persons are grouped by Age and then by Gender
			Map<Integer, Map<String, List<Person>>> biMap = new HashMap<>();
			persons.forEach(person -> biMap.computeIfAbsent(person.getAge(), HashMap::new)
					.merge(person.getGender(), new ArrayList<>(Arrays.asList(person)), 
							(l1, l2) -> {
								l1.addAll(l2);
								return l1;
							}));
			System.out.println("Contents of BiMap");
			biMap.forEach((age, m) -> System.out.println(age+" -> "+ m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
