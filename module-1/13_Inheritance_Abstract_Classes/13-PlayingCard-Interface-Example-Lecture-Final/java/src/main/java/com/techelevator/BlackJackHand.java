package com.techelevator;

import java.util.ArrayList;

// final on a class indicates it cannot be inherited (i.e. cannot be a super class)

public final class BlackJackHand	 implements CardHand {  // This class is a type of CardHand

	private int numCardsInHand = 2;
	
	private ArrayList<PlayingCard> aHand;
	
	public BlackJackHand() {
		aHand = new ArrayList<PlayingCard>(numCardsInHand);  // you can provide an estimate of how
		                                                     // elements you expect for an ArrayList
		                                                     // to be sure there is enough room in 
		                                                     // memory to hold the # of elems you expect
	}
	
	@Override   // Check to be sure this method is actually the method required by the interface
	public ArrayList<PlayingCard> getHand() {
		return aHand;
	}

	@Override   // Check to be sure this method is actually the method required by the interface
	public final void addCard(PlayingCard aCard) {  // final on a method indicates it cannot be overriden
		aHand.add(aCard);
		numCardsInHand++;
		}

	@Override   // Check to be sure this method is actually the method required by the interface
	public void emptyHand() {
		aHand.clear();

	}

	@Override   // Check to be sure this method is actually the method required by the interface
	public void show() {
		for (PlayingCard aCard : aHand)
		{
			System.out.println(aCard);
		}
			return;
	}
	
	public void dealHand(CardDeck aDeck) {
		for (int i=0; i < numCardsInHand; i++ ) {
			aHand.add(aDeck.dealCard());
		}	
	}
	
}
	
