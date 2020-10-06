package com.techelevator.myFileReadingCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {
	
	/*
	 * This program will read each line from the numbers.txt file
	 * and display each number in the line and the sum of those numbers
	 * @throws FileNotFoundException
	 */

	public static void main(String[] args) throws FileNotFoundException {
		
		// Define the input file and Scanner object to read it
		File myFile = new File("./data/Numbers.txt");	// Assign a File object to numbers.txt
		
		if(!myFile.exists() || !myFile.isFile()) {
			System.out.println("Path specified is not an existing file");
			System.exit(16);
		}
		
		Scanner theFile = new Scanner(myFile);			// Assign File object to a Scanner to read it
		
		int sum = 0;			// Hold the sum of the numbers in the line read through text file
		String theLine = "";	// Hold the line with the numbers from the file
		
		
		// Loop through the file one line at a time while there are lines in the file
		//		Break the line up into individual values based on the "," to separate ints
		// For each value in the line...
		// Convert the individual values from Strings to numerics 
		//		Then add each value from the line to sum
		//		End it with displaying the values in the line & sum
		// Reset the sum before looping again so we only get the sum of the numbers on the line
		// Close the file to avoid a resource leak
		while(theFile.hasNextLine()) {
			// Read a line from the file and store it in theLine
			theLine = theFile.nextLine();
			
			// Break the line up into separate values based on ","
			String[] theValues = theLine.split(",");
			for(int i=0; i < theValues.length; i++) {
				int aValue = Integer.parseInt(theValues[i]);
				sum += aValue;
				System.out.println("Input Line Value[" + + i + "] is: " + aValue);
			}
			System.out.println("The sum of the values in the line" + sum);
			sum = 0;
			
		}
		// Now we close the file to prevent resource leak
		theFile.close();
}
}