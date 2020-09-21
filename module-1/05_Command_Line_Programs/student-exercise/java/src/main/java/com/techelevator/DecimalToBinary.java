package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		System.out.println("How many decimal values do you want to enter?");
		
		Scanner userInput = new Scanner(System.in);
		int howMany = userInput.nextInt();
		
		int[] decimal = new int[howMany];
		int[] binary = new int[howMany];
		int i = 0;
		
		while(howMany > 0)
		{
			System.out.println("\nEnter A Decimal Value: ");
			decimal[i] = userInput.nextInt();
			
			if(binary[i] >=0)
			{
			binary[i] = howMany % 2;
			
			System.out.println(binary[i]);
		
			howMany = howMany / 2;
			i++;
			}
		}
		
		//int[] binaryDigits = new int[howMany]

	}

}
