package com.techelevator.myFileProcessingCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFileProcessor {

	/*********************************************************************************
	 * This program will read each line from the numbers.txt file
	 * and write each number in the line and the sum of those numbers to a file
	 * @throws IOException 
	 *********************************************************************************/
	
	public static void main(String[] args) throws IOException {
		
		// Define a Scanner for user input
		Scanner theKeyboard = new Scanner(System.in);
		
		// Define the input file and Scanner object to read it - file is in the data folder of the project folder
		File myFile = new File("./data/numbers.txt");  // Assign a File object to numbers.txt

		// Check to be sure the File Object is assigned an existing file - terminate if not
		if (!myFile.exists() || !myFile.isFile()) {
			System.out.println("path specified is not an existing file");
			System.exit(16);   // terminate program
		}
		Scanner theFile = new Scanner(myFile);         // Assign the File Object to a Scanner
		/****************************************************************************************
		 * Define the objects necessary to write to an disk file called BigFile.Cody
		 ***************************************************************************************/
		File diskFile = new File("BigFile.Cody");         // Define a File Object to the disk file	
		
		PrintWriter outFile = null;                       // Define a PrintWriter will assign to File later
		
		// Check to see if the output file already exists and tell the user we will add to the end file	
		if (diskFile.exists()) {                             // if the file doesn't exist
			// if output file already exists - tell user we are adding to end of existing file and define objects to do so
			System.out.println(diskFile + " already exists - will add new data to the end of it");
			// To add to end of an existing file - append to a file
			// Define a FileWriter object and tell it we want to append to the file
			// FileWriter(a-File-object, boolean) - boolean-true - append, false-over write the file
			FileWriter aFileWriter = new FileWriter(diskFile, true);  // true indicates we want append the file
			
			// Define a BufferedWriter for the FileWriter to enable buffering for the file
			// BufferedWriter(a-File-Writer-object);
			BufferedWriter aBufferedWriter = new BufferedWriter(aFileWriter); 
			
			// Reassign our PrintWriter object to the BufferedWriter
			outFile = new PrintWriter(aBufferedWriter);
		}	
		else {
			outFile = new PrintWriter(diskFile);  // Define a PrintWriter object to use the File Object
		}
		
		int lineTotal  = 0;     // hold the sum of the numbers in the line we read
		String theLine = "";    // hold the line with the numbers from the file
		int linesProcessed = 0; // Count the number of lines processed
		int linesWritten = 0;   // Count the number of lines written to the file

		// Loop through the file one line at a time while there are lines in the file
		while(theFile.hasNextLine()) {
			// Read a line from the file and store it in theLine
			theLine = theFile.nextLine();
			// Break the line up into separate values based on the , separating the value
			String[] theValues = theLine.split(",");
			// Count the line that was read
			linesProcessed++;   
			//    For each value in the line...
			for(int i=0; i < theValues.length; i++) {
				// Convert the individual value from String to numeric so we can add them
				int aValue = Integer.parseInt(theValues[i]);
				// Add each value from the line to sum
				lineTotal += aValue;
				// Write the values in the line to a file
			    outFile.println("Input Line Value[" +i+"] is: " + aValue);  // Write a line to the file
			    // Count the line as written
			    linesWritten++;
			}
		//   Write the sum of the to a file
			   outFile.println("The sum of the values in the line is: " + lineTotal);  // Write the sum to the file
			   linesWritten++;
	    //    Reset sum before looping again to be sure we only get the sum of the numbers in the line
		    lineTotal = 0;
		}
		// Close all the files to write any still in the memory buffer to disk AND avoid a resource leak
		theFile.close();
		outFile.close();
		
		System.out.println("*** Program Complete - # Lines Processed: " + linesProcessed + " ***");
		System.out.println("*** # Lines Written: " + linesWritten + " ***");
	}
}