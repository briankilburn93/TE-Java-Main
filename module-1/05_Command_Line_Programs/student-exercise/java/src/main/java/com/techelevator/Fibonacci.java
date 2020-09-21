package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		int fibZero = 0;
		int fibOne = 1;
		int fibSum = fibZero + fibOne;
		
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter the Fibonacci number: ");
		int fibNum = userInput.nextInt();
		
		//System.out.print(fibZero + "," + fibOne);
		while(fibZero < fibNum)
		{
			System.out.print(fibZero + ",");
			
			fibSum = fibZero + fibOne;
			fibZero = fibOne;
			fibOne = fibSum;
		}
		System.out.print(" and that led you to " + fibNum);
	}
	
}
