package com.techelevator;

import java.util.HashMap; // include the code to support a HashMap
import java.util.LinkedHashMap;
import java.util.Map;     // include the code to support a Map
import java.util.Set;     // include the code to support a Set
import java.util.TreeMap; // include teh code to support a TreeMap

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

// Map is a Collection Class that allows the storage of key-value pair
// Use it to associate one value (the key) to another value (the value)
//    aka Associative Array
//
//  keys are unique - only one entry with a specific key-value per Map
//
// Types of Maps:   HashMap       - un-ordered Map - entries may be in any order
//                  TreeMap       - ordered Map    - entries are stored in key sequence
//                  LinkedHashMap - ordered Map    - entries are stored in the order they are added
//

// To define a Map:  
//
//		Map<key-datatype, value-datatype> name     = new HashMap<key-datatype, value-datatype>();
//		HashMap<key-datatype, value-datatype> name = new HashMap<key-datatype, value-datatype>();

		// Define a Map to associate People with where they live. ex "Frank" - "Mayfield"
	    	
		Map<String, String> residence = new LinkedHashMap<String, String>();
		
		// Add some entries to the Map
		residence.put("Frank", "Mayfield");
		residence.put("Brandon", "Sandusky");
		residence.put("Cody", "Akron");
		residence.put("Boris", "Twinsburg");
		residence.put("Jake", "Lakewood");
		residence.put("Vince", "Mentor");
		residence.put("Gabby", "S. Euclid");
		residence.put("Ashley", "Lakewood");
		
		//  Access Map entries using .get(key-you-want) - .get() returns the value
	    //                                                       or null if value not found
		System.out.println("Cody lives in " + residence.get("Cody"));
		System.out.println("Boris lives in " + residence.get("Boris"));
		System.out.println("Dame Judy Dench lives in " + residence.get("Dame Judy Dench"));
		
		String aName = "Boris";
		
		System.out.println(aName + " lives in " + residence.get(aName));
		
		System.out.println("---------------------------------------------------------\n");
	
		// To process all entries in a Map, you need to get a list of all the keys in the Map
		//    and then iterate through the list of keys using a for-loop or for-each loop
		
		//    .keySet() - Return a Set object with all the keys in a Map
		
		// A Set is a Collection class of un-ordered elements that must have unique values
		//     (different than ArrayList in that values do not have to unique in ArrayList)
	
//		Set(datatype-of-keys)
		Set<String> theKeys = residence.keySet();  // Get a list of keys in the Map and store in theKeys
		
		// Iterate through the Set of keys using the values to access the Map
		//     current-entry  : the-Set-Object
		for (String thePerson : theKeys) {
			System.out.println("Map key: " + thePerson + ", Map value: "+ residence.get(thePerson));		
		}
		System.out.println("---------------------------------------------------------\n");
		
		// key values in a Map must be unique
		// if you try to add a entry with a key that already exists, the value gets updated to the new value
		//         it doesn't give any indication the key already existed and the value was updated
		
		System.out.println("Jake lives in " + residence.get("Jake"));
		System.out.println("Try to add the Jake that lives in Strongsville to the Map");
		residence.put("Jake", "Strongsville");
		System.out.println("Jake lives in " + residence.get("Jake"));
		
		System.out.println("---------------------------------------------------------\n");
		
		// Entries can be removed from  Map using the .remove(key-to-be-removed)
		//     No error or other indication if you try to remove something not in the Map
		System.out.println("Frank lives in " + residence.get("Frank"));
		System.out.println("Try to remove the entry with the Frank");
		residence.remove("Frank");
		System.out.println("Frank lives in " + residence.get("Frank"));
		
		System.out.println("Douglas lives in " + residence.get("Douglas"));
		System.out.println("Try to remove the entry with the Douglas");
		residence.remove("Douglas");
		System.out.println("Douglas lives in " + residence.get("Douglas"));
		
		System.out.println("---------------------------------------------------------\n");
		
		System.out.println("Does anyone live in Lakewood? " + residence.containsValue("Lakewood"));
		System.out.println("Does anyone live in Parma? " + residence.containsValue("Parma"));
		
		System.out.println("Does anyone live in same city as Ashley? " 
		                 + residence.containsValue(residence.get("Ashley")));
		
		System.out.println("The values in Map are: " + residence.values());
	}
}
