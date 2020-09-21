package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		double convertedTemp = 0;
		String inFOrC = "";
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Please enter the temperature:");
		double temperature = userInput.nextDouble();
		
		userInput.nextLine();
		
		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit?");
		inFOrC = userInput.nextLine();
		
		if(inFOrC.contains("F") || inFOrC.contains("f"))
		{
			convertedTemp = (temperature - 32) / 1.8;
			System.out.printf("%.2fF is %.2fC.",temperature, convertedTemp);
		}
		else if(inFOrC.contains("C") || inFOrC.contains("c"))
		{
			convertedTemp = (temperature * 1.8) + 32;
			System.out.printf("%.2fC is %.2fF.",temperature, convertedTemp);
		}
		
	}

}
