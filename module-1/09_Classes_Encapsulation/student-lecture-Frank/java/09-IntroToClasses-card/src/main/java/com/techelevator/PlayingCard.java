package com.techelevator;

public class PlayingCard {
//-----------------------
// A Class to represent a Playing Card
//-----------------------
	
/***************************
* 
* Define the data members of the Class
* 
* Data in class includes an access modifier that specifies
* 	who/what has access to the data.
* 
* public - anyone has access
* private - only members of the class have access
* 
***************************/
	
	private int cardValue;		// value of the card Ace = 1, J = 11, Q = 12, K = 13
	private String cardSuit; 	// suit of the card
	private String cardShape;	// shape of the card
	private String cardColor;	// color of the card
	private boolean faceUp;		// is the card faceUp - true if it is, false if it's not
	
//*********************************
// *Methods to support the Class
//*********************************
	
/*
 * Methods to initialize a new object - we want to control the values assigned to our objects
 * 
 * a constructor is a class method that initializes object for the class when they are created
 * 	
 * 		1. They have the same name as the class
 * 		2. They cannot return anything
 * 		3. 
 * 
 * 
 * You may code as many constructors as you need as long as the parameters are different
 * 
 * a default constructor is one that takes no parameters
 * 
 * If you don't provide constructor, Java runs its own default constructor which initializes: 
 * 		numeric to 0, Objects to null, and booleans to false
 * 
 * 
 *  a default constructor - create a default PlayingCard
 *  
 *  		default cardValue - 1 (Ace)
 *  		default cardSuit - Spades
 *  		default cardShape - Rectangle
 *  		default faceUp - false
 */
	
	public PlayingCard() {	//default constructor (ctor) - assign default values to our Card
		cardValue = 1;
		cardSuit = "Spades";
		cardColor = "Black";
		cardShape = "Rectangle";
		faceUp = false;
	}
	
//Constructor to create a PlayingCard from values provided by the User
	//parameters are the value the user wants for their playing card
	
	public PlayingCard(int value, String suit, String color, boolean faceUp) {
		cardValue = value;
		cardSuit = suit;
		cardColor = color;
		cardShape = "Rectangle";
		this.faceUp = faceUp;	//parameter has the same name as a data member variable
								//the data member is used instead of the parameter
								//unless you code "this." which says to use the data m
	}
	
	/*
	 * method called getters/setters to allow processes outside the class to access our data
	 * 
	 * We control the access to the data through getters/setters
	 * 
	 * getters - return values from the class to the user
	 * setters - receive values from the user to set data member
	 * 
	 * Eclipse will generate standard getters/setters for you
	 */
	
// toString() method to convert our Class to a String
	
// Override the Object class toString() to behave the way we have it to
	// An override is a method with the same name and parameters as a  higher level method, but different behavior
	
	// access return
	// modifier type name(any parameters)
	
public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public String getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}

	public String getCardShape() {
		return cardShape;
	}

	public void setCardShape(String cardShape) {
		this.cardShape = cardShape;
	}

	public String getCardColor() {
		return cardColor;
	}

	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}

	public boolean isFaceUp() {	// standard getter for boolean is called isVariableName
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

public String toString() {	// return a PlayingCard as a String
	return "Card Value: " + cardValue + " Card Suit: " + cardSuit + " Card Color: " + cardColor + " Card Shape: " + cardShape + " Face Up: " + faceUp;
}

public String sethMethod() {	// return a PlayingCard as a String
	return "Told you Seth was a Method";
}
	
}
