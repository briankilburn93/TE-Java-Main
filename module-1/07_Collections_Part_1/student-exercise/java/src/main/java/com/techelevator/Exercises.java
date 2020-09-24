package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
	 array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
	 array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
	 */
	public List<String> array2List(String[] stringArray) {
		ArrayList<String> newList = new ArrayList<>();
		// Loop through the array that is passed and elements to the new Array List
		for(int i=0; i < stringArray.length; i++)
		{
			newList.add(stringArray[i]);
		}
		return newList;
	}

	/*
	 Given a list of Strings, return an array containing the same Strings in the same order
	 list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
	 list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
	 list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
	 */
	public String[] list2Array(List<String> stringList) {
		String[] newArray = new String[stringList.size()]; // Create an array to return, that is the size of ArrayList
		
		for(int i=0; i<stringList.size(); i++)
		{
			newArray[i] = stringList.get(i);
		}
		return newArray;
	}

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
	public List<String> no4LetterWords(String[] stringArray) {
		ArrayList<String> newList = new ArrayList<>();

		for(int i=0; i < stringArray.length; i++)
		{
			if(stringArray[i].length() != 4)
			{
				newList.add(stringArray[i]);
			}
		}
		return newList;
	}

	/*
	 Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
	 arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
	 arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
	 arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
	 */
	public List<Double> arrayInt2ListDouble(int[] intArray) {
		List<Double> intToDouble = new ArrayList<>();

		for(int i: intArray)
		{
			double addDouble = (double)i/ 2;	
			intToDouble.add(addDouble);
		}
		return intToDouble;
	}

	/*
	 Given a List of Integers, return the largest value.
	 findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
	 findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
	 findLargest( [34070, 1380, 81238, 7782, 234, 64362, 627] ) -> 64362
	 */
	public Integer findLargest(List<Integer> integerList) {
		List<Integer> theLargest = new ArrayList<>();
		int finalNumber = integerList.get(0);
		
		for(int i=0; i < integerList.size(); i++)
		{
			if(integerList.get(i) >= finalNumber)
			{
				finalNumber = integerList.get(i);
			}
		}
		return finalNumber;
	}

	/*
	 Given an array of Integers, return a List of Integers containing just the odd values.
	 oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
	 oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
	 oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
	 */
	public List<Integer> oddOnly(Integer[] integerArray) {
		List<Integer> oddOnlyIntList = new ArrayList<>();
		
		for(int i=0; i < integerArray.length; i++)
		{
			if(integerArray[i] % 2 == 1)
			{
				oddOnlyIntList.add(integerArray[i]);
			}
		}
		return oddOnlyIntList;
	}

	/*
	 Given a List of Integers, and an int value, return true if the int value appears two or more times in
	 the list.
	 foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
	 foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
	 foundIntTwice( [9, 23, 44, 2, 88, 44], 44) -> true
	 */
	public boolean foundIntTwice(List<Integer> integerList, int intToFind) {
		
		boolean onlyOnce = false;
		boolean twoOrMore = false;
		
		for(int i: integerList)
		{
			if(i == intToFind)
			{
				if(!onlyOnce)
				{
					onlyOnce = true;
				}
				else
				{
					twoOrMore = true;
				}
			}
		}
		return twoOrMore;
	}

	/*
	 Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
	should be replaced by the String "Fizz", any multiple of 5 should be replaced by the String "Buzz",
	and any multiple of both 3 and 5 should be replaced by the String "FizzBuzz"
	** INTERVIEW QUESTION **
	
	fizzBuzzList( {1, 2, 3} )  ->  [1, 2, "Fizz"]
	 fizzBuzzList( {4, 5, 6} )  ->  [4, "Buzz", 6]
	 fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  [7, 8, "Fizz", "Buzz", 11, "Fizz", 13, 14, "FizzBuzz"]
	
	 HINT: To convert an integer x to a string you can call x.toString() in your code (e.g. if x = 1 then x.ToString()
	 equals "1")
	 */
	public List<String> fizzBuzzList(Integer[] integerArray) {
		ArrayList<String> fizzBuzzWordAdd = new ArrayList<String>();
		
		for(Integer i: integerArray)
		{
			if(i % 3 == 0 && i % 5 == 0)
			{
				fizzBuzzWordAdd.add("FizzBuzz");
			}
			else if(i % 3 == 0)
			{
				fizzBuzzWordAdd.add("Fizz");
			}
			else if(i % 5 == 0)
			{
				fizzBuzzWordAdd.add("Buzz");
			}
			else
			{
				String numString = i.toString();
				fizzBuzzWordAdd.add(numString);
			}
		}
		return fizzBuzzWordAdd;
	}

	/*
	 Given two lists of Integers, interleave them beginning with the first element in the first list followed
	 by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
	 Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
	 list to the new list before returning it.
	 interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
	 */
	public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {
		List<Integer> combinedList = new ArrayList<Integer>();  // create the return list

		// Happy path - both Lists are the same size
		// Edge case - Lengths are different
//		     copy all the element for the length of the shorter one
//		              (figure out which one is shorter)
//		     copy the remaining elements from the longer one into combined list

		// Determine the length of the short list

		int lengthShorter = 0;   // Contains the length of the shorter list

		boolean listOneIsShorter = false;
		boolean listTwoIsShorter = false;

		if (listOne.size() < listTwo.size()) {  // listOne is shorter
		lengthShorter = listOne.size();
		listOneIsShorter = true;
		}
		else {   // listTwo is either shorter or the same size as listOne
		lengthShorter = listTwo.size();
		listTwoIsShorter = true;
		}

		int lastElementCopied = 0;    // Will contain the index of the last element copied to combinedList

		// Go through listOne and listTwo one element at a time
//		      adding the current element to the combined list
//		      in order of listOne element first and the listTwo second

		for(int i = 0; i < lengthShorter; i++) {  // Loop for the size of the shorted list
		combinedList.add(listOne.get(i));      //    Add the current element from listOne to combinedList
		combinedList.add(listTwo.get(i));      //    Add the current element from listTwo to combinedList
		lastElementCopied = i;                 // Remember the index of the last element copied
		}

		// Now we have copied all elements for the length of shorter list
		// we need to copy the elements from the longer one into combinedList

		if (listOneIsShorter) { // if listOne was shorter copy the remaining elements from listTwo
		                   //                    from where we left off in listTwo
		for (int i = lastElementCopied + 1; i < listTwo.size(); i++) {
		combinedList.add(listTwo.get(i)); // Add an element from listOne to combinedList
		}
		}
		else {  // listTwo was shorter copy the remaining elements from listOne
		   //                    from where we left off in listOne
		for (int i = lastElementCopied + 1; i < listOne.size(); i++) {
		combinedList.add(listOne.get(i)); // Add an element from listTwo to combinedList
		}
		}
		return combinedList;   // return the combined list
		}

}
