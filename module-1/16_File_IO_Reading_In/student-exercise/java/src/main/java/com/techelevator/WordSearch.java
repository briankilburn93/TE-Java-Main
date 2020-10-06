package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		File myFile = new File("alices_adventures_in_wonderland.txt");	// To automatically read required text file
		Scanner theFile = new Scanner(myFile);
		
		if(!myFile.exists() || !myFile.isFile()) {
			System.out.println("Path specified is not an existing file");
			System.exit(42069);
		}
		
		System.out.println("Please enter a search String to find in the text: ");
		Scanner searchString = new Scanner(System.in);
		String userWord = searchString.nextLine();
		System.out.println("You are searching for: " + userWord);
		
		System.out.println("Do you care about case sensitivity? (Y/N)");
		Scanner yesOrNo = new Scanner(System.in);
		String userYesOrNo = yesOrNo.nextLine();
		
		int lineNumber = 1;
		
		if(userYesOrNo.toLowerCase().contains("y")) {
			while(theFile.hasNextLine()) {
				String currentLine = theFile.nextLine();
				
					if(currentLine.contains(userWord)) {
						System.out.println(lineNumber + ")     " + currentLine);
				}
					lineNumber++;
			}
		}
		else if(userYesOrNo.toLowerCase().contains("n")) {
			userWord = userWord.toLowerCase();
			while(theFile.hasNextLine()) {
				String currentLine = theFile.nextLine();
				
					if(currentLine.toLowerCase().contains(userWord)) {
						System.out.println(lineNumber + ")     " + currentLine);
				}
					lineNumber++;
			}
		}
		theFile.close();
		searchString.close();
		yesOrNo.close();
}
}