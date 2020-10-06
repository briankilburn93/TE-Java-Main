package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
//import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) throws FileNotFoundException {
		
		File diskFile = new File("FizzBuzz.txt");			// Define a File Object to represent the disk file
		PrintWriter outFile = new PrintWriter(diskFile);	// Define a PrintWriter object to use the File Object we created
		
		String numContains = "";
		
		for(int i = 1; i <= 300; i++) {
			
			numContains = String.valueOf(i);
			
			if (i % 3 == 0 && i % 5 == 0) {
				outFile.println(i + "   FizzBuzz");
			}
			else if(i % 3 == 0) {
				outFile.println(i + "   Fizz");
			}
			else if(i % 5 == 0) {
				outFile.println(i + "   Buzz");
			}
			else if(numContains.contains("3") && numContains.contains("5")) {
				outFile.println(i);
			}
			else if(numContains.contains("3")) {
				outFile.println(i + "   Fizz");
			}
			else if(numContains.contains("5")) {
				outFile.println(i + "   Buzz");
			}
			else {
				outFile.println(i);
			}
		}
		outFile.println("FizzBuzz.txt has been created.");

		outFile.close();
	}
}
