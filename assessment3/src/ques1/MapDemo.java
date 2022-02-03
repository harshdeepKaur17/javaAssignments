package ques1;

import java.util.*;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("raj", 95);
		map.put("ekta", 75);
		map.put("rajiv", 85);
		map.put("sunita", 66);
		map.put("gunika", 99);
		

		// Print map using stream
		System.out.println("------printing map Using Stream------");
		map.entrySet().stream()
				.forEach(record -> System.out.println("Name: " + record.getKey() + ", Marks: " + record.getValue()));

		// Print only that records that contain key contains raj
		System.out.println("------printing map Records that contain key as raj------");
		map.entrySet().stream().filter(entry -> (entry.getKey()).equals("raj"))
				.forEach(record -> System.out.println("Name: " + record.getKey() + ", Marks: " + record.getValue()));

		// Print map sorted by key
		System.out.println("------printing map sorted by key------");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach(record -> System.out.println("Name: " + record.getKey() + ", Marks: " + record.getValue()));

		// Print map sorted by values
		System.out.println("------printing map sorted by values------");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEach(record -> System.out.println("Name: " + record.getKey() + ", Marks: " + record.getValue()));

		// Print map reverse sorted by the key
		System.out.println("------printing map sorted by key in reverse order------");
		map.entrySet().stream().sorted((a, b) -> b.getKey().compareTo(a.getKey()))
				.forEach(record -> System.out.println("Name: " + record.getKey() + ", Marks: " + record.getValue()));
	}
}
