package com.techelevator;

public class HomeworkAssignment {
	
	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	
	public HomeworkAssignment(int possibleMarks, String submitterName) {
		
		this.possibleMarks = possibleMarks;
		this.submitterName = submitterName;
	}
	
	public int getEarnedMarks() {
		return earnedMarks;
	}
	public void setEarnedMarks(int earnedMarks) {
		this.earnedMarks = earnedMarks;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public String getLetterGrade() {
		
		int grade = ((getEarnedMarks() * 100) / getPossibleMarks());
		
		if(grade >= 90)
		{
			letterGrade = "A";
		}
		else if(grade >= 80)
		{
			letterGrade = "B";
		}
		else if(grade >= 70)
		{
			letterGrade = "C";
		}
		else if(grade >= 60)
		{
			letterGrade = "D";
		}
		else
		{
			letterGrade = "F";
		}
		return letterGrade;
	}
	
}
