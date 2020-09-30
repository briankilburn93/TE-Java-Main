package com.techelevator;

import java.util.ArrayList;


public interface CardHand {	// Define the behaviors for any thing that wants to a type of CardHand
							// Any class that implements the CardHand MUST be sure these methods are defined
							//		the class implement CardHand could have additional methods
	
	public ArrayList<PlayingCard> getHand();	// return the cards in the CardHand as an ArrayList

	public void addCard(PlayingCard aCard);		// add the PlayingCard passed as a parameter to the CardHand
	
	public void emptyHand();					// remove all the PlayingCard objects in a CardHand

	public void show();							// show each PlayingCard in the CardHand

}
