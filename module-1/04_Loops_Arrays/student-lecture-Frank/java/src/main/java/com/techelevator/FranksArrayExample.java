package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program"); 
		
		int score1 = 10;
		int score2 = 20;
		int score3 = 50;
		int score4 = 67; //added one more score
		
		int sum = 0;
		double avg = 0;
		
		//Code is "tightly coupled" when data changes and you have to change the code (dependent on data)
		//Code is "lightly coupled" when you can freely change it (arrays help with this)
		
		sum = score1 + score2 + score3 + score4; //need to update when new score is added
		avg = sum / 4; //need to update 4 to number of scores if a new score is added
		
		System.out.println("The sum of the numbers is " + sum);
		System.out.printf("The average of the numbers is %.1f\n", avg);
		
		
		int[] scores = {10, 20, 50, 67, 124, 87};
		sum = 0;
		
		for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        avg = sum / scores.length;

        System.out.println("The sum of the numbers is " + sum);
        System.out.printf("The average of the sum is %.1f\n", avg);
        
	}   
   
}