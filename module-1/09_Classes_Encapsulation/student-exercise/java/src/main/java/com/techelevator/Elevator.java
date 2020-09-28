package com.techelevator;

public class Elevator {
	
	public int currentFloor = 1;
	public int numberOfFloors;
	public boolean doorOpen;
	
	public Elevator(int numberOfLevels) {
		
		this.numberOfFloors = numberOfLevels;
		
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}
	
	public void openDoor() {
		doorOpen = true;
	}
	
	public void closeDoor() {
		doorOpen = false;
	}
	
	public void goUp(int desiredFloor) {
		
		if(!doorOpen && desiredFloor <= numberOfFloors && currentFloor < desiredFloor)
		{
			currentFloor++;
		}
		
	}
	
	public void goDown(int desiredFloor) {
		
		if(!doorOpen && desiredFloor >= 1 && desiredFloor < currentFloor)
		{
			currentFloor--;
		}
		
	}

}
