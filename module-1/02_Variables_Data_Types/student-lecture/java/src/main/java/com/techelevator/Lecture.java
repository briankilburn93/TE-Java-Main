package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;

		System.out.println("We have " + numberOfExercises + " exercises" + "\n");

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half = 0.5;

		System.out.println("Half in decimal form is " + half + "\n");

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";

		System.out.println("I'm attending " + name + "\n");

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;

		System.out.println("There are " + seasonsOfFirefly + " season(s) of Firefly" + "\n");

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";

		System.out.println("My favorite language is " + myFavoriteLanguage + "\n");

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;

		System.out.println("pi = " + pi + "\n");

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName;
		myName = "Brian";
		System.out.println("My name is " + myName + "\n");

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int mouseButtons = 2;
		System.out.println("My mouse has " + mouseButtons + " buttons" + "\n");

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		double batteryPercentageLeft = 0.0;
		System.out.println("My mouse has " + batteryPercentageLeft + "% battery left" + "\n");

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int diffBtwnNumbers = 121 - 27;
		System.out.println("The difference between 121 and 27 is " + diffBtwnNumbers + "\n");

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double doubAddition = 12.3 + 32.1;
		System.out.println("Display of adding doubles: " + doubAddition + "\n");

		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "Brian Kilburn";
		System.out.println("My full name is " + fullName + "\n");

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String greetings = "Hello, " + fullName;
		System.out.println(greetings + "\n");

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Esquire";
		System.out.println(fullName + "\n");

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		fullName += " Esquire";
		System.out.println(fullName + "\n");

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String stringAndNumber = "Saw" + 2;
		System.out.println(stringAndNumber + "\n");

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		stringAndNumber += 0;
		System.out.println(stringAndNumber + "\n");

		/*
		18. What is 4.4 divided by 2.2?
		*/
		System.out.println("4.4 / 2.2 = " + 4.4 / 2.2 + "\n");

		/*
		19. What is 5.4 divided by 2?
		*/
		System.out.println("5.4 / 2 = " + 5.4 / 2 + "\n");

		/*
		20. What is 5 divided by 2?
		*/
		System.out.println("5 / 2 = " + 5/2 + "\n");

		/*
		21. What is 5.0 divided by 2?
		*/
		System.out.println("5.0 / 2 = " + 5.0 / 2 + "\n");

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println("66.6 / 100 = " + 66.6 / 100 + "\n");

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		System.out.println("Remainder of 5/2 is " + 5 % 2 + "\n");

		/*
		24. What is 1,000,000,000 * 3?
		*/
		System.out.print("This needs a long tag " + 1000000000 * 3L + ", but without the long tag you get " + 1000000000 * 3 + "\n" + "\n");

		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean doneWithExercises = false;
		System.out.println("We're done with exercises, right? " + doneWithExercises + "\n");

		/*
		26. Now set doneWithExercise to true.
		*/
		doneWithExercises = true;
		System.out.println("We are done with exercises, right? " + doneWithExercises + "\n");
		
	}

}
