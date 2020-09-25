package com.techelevator;

public class IntroToClassesCard {
        //------------------------------------------------------------------------------------------------------------
        // Application program for the Intro To Classes App
        //------------------------------------------------------------------------------------------------------------
        public static void main(String[] args) {
        /*
        *  This program will demonstrate several concepts presented in the Java cohort
        *  in the topic Introduction to Classes 		
        *  
        *  This is the application program that will instantiate and manipulate objects of our Class
        *  to do some actual work
        */
        	// instantiate a PlayingCard Object
        	// Class name = new Class();
        	
        	PlayingCard aCard = new PlayingCard();
        	
        	System.out.println("aCard is: " + aCard); // Display our PlayingCard Object
        											//+ PlayingCard Object - + requires a String to concatenate
        												//it doesn't know what to do with a PlayingCard Object
        												//is there a way available to convert a PlayingCard to a String?
        												// Yes - using the PlayingCard Class toString() method
        											// + String - created using the PlayingCard and the Object Class toString()
        												// PlayingCard Class toString() returns a String containing: 
        													//  the values in the member data with descriptive phrase
        	
        //Create a queen of hearts that is face up
        	PlayingCard jessCard = new PlayingCard(12, "Hearts", "Red", true);
        	System.out.println(jessCard);
        	
        	
   // As a user, I would like to be able to get the individual values in the object
        	//System.out.println("jessCard value is: " + jessCard.cardValue());
        	System.out.println("jessCard suit is: " + jessCard.getCardSuit());
        	
        	
        	
        	//System.out.println(aCard.sethMethod());
        	
	}
}
		 

