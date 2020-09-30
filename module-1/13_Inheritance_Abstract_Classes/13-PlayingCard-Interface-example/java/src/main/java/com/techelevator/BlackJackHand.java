package com.techelevator;

import java.util.ArrayList;

// final on a class indicates it cannot be inherited (ie. cannot be a super class)
//		ie. public final class BlackJackHand

public class BlackJackHand	 implements CardHand {	// This class is a type of CardHard

	private int numCardsInHand = 2;
	
	private ArrayList<PlayingCard> aHand;
	
	public BlackJackHand() {
		aHand = new ArrayList<PlayingCard>(numCardsInHand);	// you can provide an estimate of how
															// 		element you expect for an ArrayList
															// 		to be sure there is enough room in
															// 		memory to hold the # of elements you expect
	}
	
	@Override	// Check to be sure this method is actually the method required by the interface
	public ArrayList<PlayingCard> getHand() {
		return aHand;
	}

	@Override	// Check to be sure this method is actually the method required by the interface
	public void addCard(PlayingCard aCard) {
		aHand.add(aCard);
		numCardsInHand++;
	}

	@Override	// Check to be sure this method is actually the method required by the interface
	public void emptyHand() {
		aHand.clear();

	}

	@Override
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
	
