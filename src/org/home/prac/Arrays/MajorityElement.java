package org.home.prac.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class MajorityElement {

	private static Optional<Integer> findMajorityElement(int[] arr, int size) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i: arr) {
			int count = map.containsKey(i) ? map.get(i) : 0;
			map.put(i, count + 1);
		}
		int minFreq = (size/2);
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > minFreq) {
				return Optional.of(entry.getKey());
			}
		}
		return Optional.empty();
	}
	
	public static void main1(String[] args) {
		int a[] = {1, 3, 3, 1, 2, 3, 3}; 
		Optional<Integer> majorityNumber = findMajorityElement(a, a.length);
		if(majorityNumber.isPresent()) {
			System.out.println(majorityNumber.get());
		} else {
			System.out.println("NONE");
		}
	}
	
	public static void main(String[] args) {
		
	}
}
