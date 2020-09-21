package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		double convertedLength = 0;
		String inFeetOrMeters = "";
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Please enter the length:");
		double length = userInput.nextDouble();
		
		userInput.nextLine();
		
		System.out.println("Is the length in (m)eter, or (f)eet?");
		inFeetOrMeters = userInput.nextLine();
		
		if(inFeetOrMeters.contains("F") || inFeetOrMeters.contains("f"))
		{
			convertedLength = (length * 0.3048);
			System.out.printf("%.2ff is %.2fm.",length, convertedLength);
		}
		else if(inFeetOrMeters.contains("C") || inFeetOrMeters.contains("c"))
		{
			convertedLength = (length * 3.2808399);
			System.out.printf("%.2fm is %.2ff.",length, convertedLength);
		}

	}

}
