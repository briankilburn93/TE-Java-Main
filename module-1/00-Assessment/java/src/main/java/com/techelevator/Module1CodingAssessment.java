package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Module1CodingAssessment {
	
	private static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) throws FileNotFoundException {

		File itemFile = new File("TellerInput.csv");  // Call in the CSV file
		Scanner tellerFile = new Scanner(itemFile); // called a scanner to read the CSV file
		
		double aGetBalance = 0;
		
		while (tellerFile.hasNextLine()) {
			String itemLine = tellerFile.nextLine();
			String tellerList[] = itemLine.split(",");
			
			TellerMachine aTellerList = new TellerMachine(tellerList[0], Double.parseDouble(tellerList[1]), Double.parseDouble(tellerList[2]));
			aGetBalance = aGetBalance + aTellerList.getBalance();
			
			//System.out.println(aTellerList);  //Doesn't display required per ReadMe, but it will display the requested toString() method in TellerMachine
		}
		System.out.println("Your total balance is: $" + df.format(aGetBalance));
		tellerFile.close();
	}
	
	public boolean cardNumber(String aCardNumber) {
		
		if(aCardNumber.length() == 16 && aCardNumber.substring(0,1).equals("5")) {
			return true;
		}
		else if((aCardNumber.length() == 16 || aCardNumber.length() == 13) && aCardNumber.substring(0,1).equals("4")) {
			return true;
		}
		else if(aCardNumber.substring(0,1) == "3" && (aCardNumber.substring(1,2) == "4" || aCardNumber.substring(1,2) == "7")) {
			return true;
		}
		else {
			return false;
		}
	}
}
