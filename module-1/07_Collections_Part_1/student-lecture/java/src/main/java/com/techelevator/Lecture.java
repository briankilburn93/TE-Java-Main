package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		//ArrayList is a type of List
		//to define: (put the datatype of objects to be stores inside <>
		//List<String> anArrayList = new ArrayList<String>;
		//-or-
		//ArrayList<String> anArrayList = new ArrayList<String>();
		//-or-
		//ArrayList<String> = new ArrayList<>(); //Popular Method
		
		List<String> someJavaStudents = new ArrayList<String>();
		
		someJavaStudents.add("Bri"); // Add an element to the ArrayList
		someJavaStudents.add("Amanda"); // Add an element to the ArrayList
		someJavaStudents.add("Semih"); // Add an element to the ArrayList
		someJavaStudents.add("Ashley"); // Add an element to the ArrayList
		someJavaStudents.add("John"); // Add an element to the ArrayList
		someJavaStudents.add("Cody"); // Add an element to the ArrayList
		

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		//Loop through ArrayList and display elements
		//.size return the number of elements in an ArrayList
		//.get(index) returns the element at the specified index in the ArrayList
		
		for(int i = 0; i < someJavaStudents.size(); i++)
		{
			System.out.println("element #" + i + ": " + someJavaStudents.get(i));
		}

		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		someJavaStudents.add("John");
		
		for(int i = 0; i < someJavaStudents.size(); i++)
		{
			System.out.println("element #" + i + ": " + someJavaStudents.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		someJavaStudents.add(3, "Seth"); // Insert Seth at index 3 and move everyone down
		someJavaStudents.add("Frank");
		
		for(int i = 0; i < someJavaStudents.size(); i++)
		{
			System.out.println("element #" + i + ": " + someJavaStudents.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		someJavaStudents.remove(5);
		
		someJavaStudents.remove(someJavaStudents.indexOf("Frank")); // Remove the first instance of "Frank"
		
		for(int i = 0; i < someJavaStudents.size(); i++)
		{
			System.out.println("element #" + i + ": " + someJavaStudents.get(i));
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		if(someJavaStudents.contains("Douglas"))
		{
			System.out.println("Douglas is in the list");
		}
		else
		{
			System.out.println("Douglas is not in the list");
		}


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		
		System.out.println("Bri is at index #" + someJavaStudents.indexOf("Bri") + " on the list");
		System.out.println("Bri is at index #" + someJavaStudents.indexOf("Yoav") + " on the list");


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		
		// .toArray(new array specification)
		// new datatype[# of elements in array]
		// new datatype[listname.size()]
		String[] strJavaStudents = someJavaStudents.toArray(new String[someJavaStudents.size()]);
		
		for(int i = 0; i < strJavaStudents.length; i++)
		{
			System.out.println("array element #" + i + ": " + strJavaStudents[i]);
		}
		
		String[] javaStudents = new String[someJavaStudents.size()]; // Create an array the size of the ArrayList
		
		for(int i=0; i < someJavaStudents.size(); i++) // Used to loop through ArrayList
		{
			javaStudents[i] = someJavaStudents.get(i); // Assign an ArrayList element to the corresponding Array element
		}
		
		
		System.out.println("####################");
		System.out.println("Primitive Wrappers - Creating Object for primitives");
		System.out.println("So primitive values can be used where only objects are allowed");
		System.out.println("####################");
		
		//Every primitive has a "Wrapper" Class to use it as an Object
		//int - Integer
		//double - Double
		//float - Float
		//boolean - Boolean
		//char - Character
		
		Integer i = new Integer(6); //Integer Object with the value 6
		Integer j = new Integer(16); //Integer Object with the value 16
		Integer k = new Integer("61"); //Integer Object with the value 61 (automatic convert from String)
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		intList.add(i);
		intList.add(j);
		intList.add(k);
		


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		//foreach loop - Always goes from the start of the collection to the end
		//               (can't start anywhere but beginning)
		//               (or end before the end)
		//               (and you can't skip elements)
		//
		//  for(datatype anElementName : collection-name)
		//
		//  go through the collection one element at a time from the start to the end
		//  each time through the loop the current element will be stored in the element name you give it
		//  use the element name specified to access the current element while in the loop
		
		//Process the ArrayList using the for-each loop
		System.out.println("\nDisplay using regular for-each loop");
		for(String aStudent : someJavaStudents)                // In the loop, aStudent will be the current element
		{
			System.out.println("element in the ArrayList: " + aStudent);
		}
		
		// Process the ArrayList using a regular for loop
		System.out.println("\nDisplay using regular for-loop");
		for(int studentNumber = 0; studentNumber < someJavaStudents.size(); studentNumber++)
		{
			System.out.println("element #" + studentNumber + ": " + someJavaStudents.get(studentNumber));
		}


	}
}
