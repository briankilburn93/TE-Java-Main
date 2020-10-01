package com.techelevator;

// This an an abstract class we don't want to allow instantiation of generic PlayingCard
//   We DO want to define the data and basic behaviors of a PlayingCard

public abstract class PlayingCard {  // adding abstract to the class header makes it an abstract class
	
	// an abstract class may contain data and behavior(methods) inherited by sub classes
	
	protected int value;    // protected allows one level of subclass below to access this data
	protected String color; // protected allows one level of subclass below to access this data  
	protected String suit;  // protected allows one level of subclass below to access this data
	                        // protected indicates you trust your first level level with this data

	public PlayingCard() {}; // An abstract will usually have a dummy ctor
	
	public PlayingCard(int value, String suit, String color) {
		this.value = value;
		this.suit  = suit;
		this.color = color;
	}
	
	public int getValue() {
		return value;
	}
	public String getColor() {
		return color;
	}
	public String getSuit() {
		return suit;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	@Override   // Ask compiler to verify this is a proper Override - same name, same parameters, same return-type
	public String toString() {
		return "PlayingCard [value=" + value + ", color=" + color + ", suit=" + suit + ", getValue()=" + getValue()
				+ ", getColor()=" + getColor() + ", getSuit()=" + getSuit() + "]";
	}
	
	@Override   // Ask compiler to verify this is a proper Override - same name, same parameters, same return-type
	public boolean equals(Object obj) {  // Receive any type of Object
		if (this == obj) {  // If compare a PlayingCard to itself
			return true;
		}
		if (obj == null) {  // If compare to an undefined PlayingCard
			return false;
		}
		if (getClass() != obj.getClass()) {  // If compare to an object of a different class
			return false;                    // getClass() return the Class of an object
		}
		PlayingCard other = (PlayingCard) obj;  // Define a PlayingCard for the object that was passed
		if (color != other.color) {
			return false;
		}
		if (suit != other.suit) {
			return false;
		}
		if (value != other.value) {
			return false;
		}
		return true;
	}

	// In order to use showCard() in Polymorphism, the super class must include it
	//      even if it does nothing
	// defining a method as abstract means that it must be defined by a sub-class
	//     abstract on a method means I don't what it actually does, but you have to have one.
	//              the sub-class defines the specific behavior for abstract method
	//
	// If a class has one or more abstract methods, the class must be abstract
	
	public abstract void showCard();  // abstract method so sub-class are required to define - Polymorphism
	
//  public void showCard() {}          // a method that does nothing - Polymorphism	
	                                   // use this techniques when you don't want the super class to be abstract
}
