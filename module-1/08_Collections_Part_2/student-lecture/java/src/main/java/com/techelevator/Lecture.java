package com.techelevator;

import java.util.HashMap;	// include code to support a HashMap
import java.util.LinkedHashMap;
import java.util.Map;	// include code to support a Map
import java.util.Set;	// include the code to support a Set
import java.util.TreeMap;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();


// Map is a Collection Class that allows the storage of a key-value pair
// Use it to associate one value (the key) to another value (the value)
// aka Associative Array
		
// Kinds of Maps: 
		//HashMap - unordered - entries may be in any order
		//TreeMap - ordered - entries are stored in key sequence
		//LinkedHashMap - ordered - entries are stored in the order they are added
		
		//keys are unique - only one entry with a specific key-value map
		
// To define a Map: 
		//Map<key-data-type, value-data-type> name = new HashMap<key-data-type, value-data-type>();
		
		// Define a Map to associate People with where they live. ex "Frank" - "Mayfield"
		
		Map<String, String> residence = new HashMap<String, String>();
		
		residence.put("Frank", "Mayfield");
		residence.put("Bradon", "Sandusky");
		residence.put("Cody", "Akron");
		residence.put("Boris", "Twinsburg");
		residence.put("Jake", "Lakewood");
		residence.put("Vince", "Mentor");
		residence.put("Gabby", "S. Euclid");
		residence.put("Ashley", "Lakewood");
		
		System.out.println("Cody lives in " + residence.get("Cody"));
		System.out.println("Boris lives in " + residence.get("Boris"));
		System.out.println("Dame Judy Dench lives in " + residence.get("Dame Judy Dench"));
		
		String aName = "Boris";
		
		System.out.println(aName + " lives in " + residence.get(aName));
		
		System.out.println("----------------------------");
		
		// To display all entries in a Map, you need to get a list of all the keys in the Map
		//	and then iterate through the list of keys using a for-loop or for-each loop
		
		//	.keySet() - Return a Set object with all the keys in a Map
		
		// A Set is a Collection class of unordered element that must have unique values
		//	(different than ArrayList in that values do not have to unique in ArrayList)
		
		Set<String> theKeys = residence.keySet(); // Get a list of the keys in a Map and store irt in theKeys
		
		// Iterate through the Set of keys using the values to access the Map
		
		for(String thePerson : theKeys)
		{
			System.out.println("Map key: " + thePerson + ", Map value: " + residence.get(thePerson));
		}
		
		System.out.println("----------------------------");
		
		//key values in a Map must be unique
		// if you try to add an entry with a key that already exists, the value gets updated to the new value
		System.out.println("Jake lives in " + residence.get("Jake"));
		System.out.println("Try to add the Jake that lives in Strongsville to the Map");
		residence.put("Jake", "Strongsville");
		System.out.println("Jake lives in " + residence.get("Jake"));
		
		System.out.println("----------------------------");
		
		// Can remove entries using .remove()
		System.out.println("Frank lives in " + residence.get("Frank"));
		System.out.println("Try to remove the entry with Frank");
		residence.remove("Frank");
		System.out.println("Frank lives in " + residence.get("Frank"));
		
		// No error or other indicationif you try to remove something not in the Map
		System.out.println("Douglas lives in " + residence.get("Douglas"));
		System.out.println("Try to remove the entry with douglas");
		residence.remove("Douglas");
		System.out.println("Douglas lives in " + residence.get("Douglas"));
		
		System.out.println("----------------------------");
		
		System.out.println("Does anyone live in Lakewood? " + residence.containsValue("Lakewood"));
		System.out.println("Does anyone live in Parma? " + residence.containsValue("Parma"));
		
		System.out.println("Does anyone live in the same city as Ashley? " + residence.containsValue(residence.get("Ashley")));
		
		System.out.println("The values in Map are: " + residence.values());
		
		Map<String, String> zipcodes = new HashMap<String, String>();



		zipcodes.put("44103", "Cleveland");

		zipcodes.put("44103","Shaker Heights");


		String cityTest = zipcodes.get("44103");
		
		System.out.println(cityTest);
	}

}
