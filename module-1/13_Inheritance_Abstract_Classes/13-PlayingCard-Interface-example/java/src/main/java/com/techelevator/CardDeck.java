package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

// Class to model a standard 52-card deck of cards with optional Jokers

public class CardDeck {
	// The deck a Queue (FIFO data structure)
	LinkedList<PlayingCard> deckOfCards = new LinkedList<PlayingCard>();
	private int numCardsInDeck = 54;

	public CardDeck() { // Default ctr
		resetDeck(true); // reset deck with jokers
	}

	public void showDeck() {
		System.out.println("Number of Cards in Deck: " + deckOfCards.size());
		for (PlayingCard aCard : deckOfCards) {
			System.out.println(aCard);
		}
	}

	public boolean anyCardsInDeck() {
		if (deckOfCards.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public PlayingCard dealCard() {
		if (deckOfCards.size() > 0) {
			return deckOfCards.remove();  // .remove for a Queue removes the object from Queue
		}
		else {
			 return null;
		}
	}

	public void resetDeck(boolean withJoker) {
		deckOfCards.clear();

		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "CLUBS"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "HEARTS"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "Spades"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "DIAMONDS"));
		}

		if (withJoker) {
			deckOfCards.add(new PlayingCard(0, "JOKER"));
			deckOfCards.add(new PlayingCard(0, "JOKER"));
		}
	}

	public void shuffleDeck() {
		resetDeck(false);						// reset deck with no jokers
		Collections.shuffle(deckOfCards);		// use the built-in Collections class shuffle method to shuffle deck
	 											//LinkedList is a Collections class subclass so we can use
												//		any Collections method to manipulate
	}

}