package com.techelevator;

import java.util.Scanner;

public class CommandLineSampleProgram {

	public static void main(String[] args) {
		/*
		System.out.println("Welcome to Frank's Command Line Sample Program\n");
		
		
		Scanner theKeyboard = new Scanner(System.in);
		
		String aLine = "";
		int aNumber = 0;
		
		System.out.println("Please enter a line then press enter: ");
		aLine = theKeyboard.nextLine();
		System.out.println("\nThe line you entered was a " + aLine);
		
		System.out.println("Please enter a number: ");
		aNumber = theKeyboard.nextInt();
		System.out.println("\nYou entered this number: " + aNumber + " and twice that is " + aNumber*2);
		
		System.out.println("Please enter another number: ");
		aNumber = theKeyboard.nextInt();
		System.out.println("\nYou entered this number: " + aNumber + " and twice that is " + aNumber*2);
		
		theKeyboard.nextLine(); //clear any line

		System.out.println("Please enter another line then press enter: ");
		aLine = theKeyboard.nextLine();
		System.out.println("\nThe line you entered was " + aLine);
		
		*/
		// When you type a line in the keyboard and press enter
		//  the enter key is converted to new-line character
		//Scanner scans the keyboard for characters until it sees a new line character (enter)
		
		/*
		boolean doYouUnderstand = false;
		Scanner cody = new Scanner(System.in);
		String userName = "yes";

		while (doYouUnderstand == false)
		{
		    System.out.println("Do you understand while loops? Type y or n");
		    userName = cody.nextLine();
		    
			if(userName.contains("y"))
		        {
		            doYouUnderstand = true;
		    		System.out.println("\nYou typed " + userName + " which contained y, so you left the loop");
		        }
		    else if(userName.contains("n"))
		        {
		            doYouUnderstand = false;
		    		System.out.println("\nYou typed " + userName + " which contained n, you don't understand");
		        }
		    else
		    {
		    	System.out.println("\nYou typed " + userName + " which contained no n or y, try again");
		
		    }
		}
		*/
		int sum = 0;
		Scanner theKeyboard = new Scanner(System.in);
		String aLine = "";
		
		while(true)
		{
			System.out.println("Please enter a number of end to stop: ");
			aLine = theKeyboard.nextLine();
			if(aLine.equals("end"))
			{
				break;
			}
			sum = sum + Integer.parseInt(aLine);
		}
		System.out.println("The sum of the numbers is: " + sum);
	}

}
