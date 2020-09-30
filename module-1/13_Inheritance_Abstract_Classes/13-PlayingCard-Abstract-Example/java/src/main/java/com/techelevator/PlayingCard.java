package com.techelevator;

// Make this into an ABSTRACT CLASS because we don't want to allow instantiation of generic playing card
	// We DO want to define the data and basic behaviors of a PlayingCard

public abstract class PlayingCard {		// adding abstract to the class header makes it an abstract class
	
	// an abstract class my contain data and behavior(method) that are inherited by subclasses
	
	protected int value;       //protected allows one level of subclass below to access this data
	protected String color;    //protected allows one level of subclass below to access this data
	protected String suit;     //protected allows one level of subclass below to access this data
	
	
	public PlayingCard(int value, String suit, String color) {
		this.value = value;
		this.suit  = suit;
		this.color = color;
	}
	
	public PlayingCard() {}; // An abstract class will usually have a dummy constructor
	
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
	//		even if it does nothing
	// By defining a method as abstract, it means that it must be defined by a subclass
	//		abstract means I don't know what it actually does, but you have to have one.
	//			the subclass defines the specific behavior for an abstract method
	
	// If a class has one or more abstract methods, the class must be abstract

	public abstract void showCard();   // abstract method so subclasses are required to define it - Polymorphism
	
	//public void showCard() {} 	   // a method that does nothing - Polymorphism (cannot use when abstract)
									   //	use this when you DO NOT want the super class to be abstract
}
