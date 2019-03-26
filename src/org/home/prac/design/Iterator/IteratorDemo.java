package org.home.prac.design.Iterator;

import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		BikeRepository br = new BikeRepository();
		br.addBike("Honda");
		br.addBike("Yamaha");
		br.addBike("Bajaj"); 
		
		System.out.println("Iterating using while loop");
		Iterator<String> bikesIterator = br.iterator();
		while(bikesIterator.hasNext()) {
			System.out.println(bikesIterator.next());
		}
		
		System.out.println("Iterating using For each loop");
		for(String bike: br) {
			System.out.println(bike);
		}
	}
}
