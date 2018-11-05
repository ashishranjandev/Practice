package org.home.prac.java8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();
		try {
			BufferedReader reader = 
					new BufferedReader(
							new InputStreamReader(
									CollectorsExample.class.getResourceAsStream("people.txt")));

			Stream<String> stream = reader.lines();
			stream.map(line -> {
				String[] s = line.split(" ");
				Person person = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2]);
				persons.add(person);
				return person;
			}).forEach(System.out::println);
			
			Stream<Person> stream2 = persons.stream();
			Optional<Person> minPerson = stream2.filter(p -> p.getAge() > 20).min(Comparator.comparing(Person::getAge));
			if (minPerson.isPresent()) {
				System.out.println("Name of Person with lowest age(Above 20) is " + minPerson.get().getName());
			} else {
				System.out.println("No person with age above 20.");
			}
			
			Stream<Person> stream3 = persons.stream();
			Optional<Person> maxPerson = stream3.max(Comparator.comparing(Person::getAge));
			if (maxPerson.isPresent()) {
				System.out.println("Name of Person with most age is " + maxPerson.get().getName());
			} else {
				System.out.println("No person in the list");
			}
			
			Map<Integer, List<Person>> personMap = 
					persons.stream().collect(Collectors.groupingBy(Person::getAge));
					System.out.println(personMap.toString());
			
			Map<Integer, Long> ageCountMap = 
					persons.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
					System.out.println(ageCountMap.toString());
			
			Map<Integer, List<String>> personNameMap = 
					persons.stream().collect(
							Collectors.groupingBy(Person::getAge,
									Collectors.mapping(Person::getName, Collectors.toList())));
					System.out.println(personNameMap.toString());
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
