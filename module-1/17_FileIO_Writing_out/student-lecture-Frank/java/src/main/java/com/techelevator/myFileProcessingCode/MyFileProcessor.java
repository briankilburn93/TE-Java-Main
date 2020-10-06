package com.techelevator.myFileProcessingCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFileProcessor {

	/*********************************************************************************
	 * This program will read each line from the numbers.txt file
	 * and write each number in the line and the sum of those numbers to a file
	 * @throws FileNotFoundException 
	 *********************************************************************************/
	
				// 
	//PrintWriter outFile = null;
				// FileWriter(a-File-object, boolean) - boolean true - append, false-overwrite the file
				//	tldr: false means you overwrite the file, true means you write into the file without erasing current stuff
	//FileWriter aFileWriter = new FileWriter(diskFile, true); 
				
				// Define a BufferedWriter for the FileWriter to enable buffering for the file
				//BufferWriter(a-FileWriter-object);
	// BufferedWriter aBufferedWriter = new BufferedWriter(aFileWriter);
	
				// Define a PrintWriter object for the BufferedWriter
	//PrintWriter outFile = new PrintWriter(aBufferedWriter);
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// Define the input file and Scanner object to read it - file is in the data folder of the project folder
		File myFile = new File("./data/numbers.txt");  // Assign a File object to numbers.txt

		// Check to be sure the File Object is assigned an existing file - terminate if not
		if (!myFile.exists() || !myFile.isFile()) {
			System.out.println("path specified is not an existing file");
			System.exit(16);   // terminate program
		}
		Scanner theFile = new Scanner(myFile);         // Assign the File Object to a Scanner
	
		//PrintWriter outFile = new PrintWriter();
		
		File diskFile = new File("BigFile.Cody");			// Define a File Object to represent the disk file
		PrintWriter outFile = new PrintWriter(diskFile);	// Define a PrintWriter object to use the File Object we created
		
		int lineTotal  = 0;  // hold the sum of the numbers in the line we read
		String theLine = ""; // hold the line with the numbers from the file
		int linesProcessed = 0;
		
		// Loop through the file one line at a time while there are lines in the file
		while(theFile.hasNextLine()) {
			// Read a line from the file and store it in theLine
			theLine = theFile.nextLine();
			// Break the line up into separate values based on the , separating the value
			String[] theValues = theLine.split(",");
			linesProcessed++;
			//    For each value in the line...
			for(int i=0; i < theValues.length; i++) {
				// Convert the individual value from String to numeric so we can add them
				int aValue = Integer.parseInt(theValues[i]);
				// Add each value from the line to sum
				lineTotal += aValue;
				//-- Write the values in the line
				outFile.println("Input Line Value[" +i+"] is: " + aValue);	//-- Write a file to the file
			}
		//--    Write the sum of the values
			outFile.println("The sum of the values in the line is: " + lineTotal);
		//    Reset sum before looping again to be sure we only get the sum of the numbers in the line
		    lineTotal = 0;
		}
		// Close the file(s) to avoid a resource leak
		theFile.close();
		outFile.close();
		System.out.println("Program Complete. Number of lines processed: " + linesProcessed);
	}
}