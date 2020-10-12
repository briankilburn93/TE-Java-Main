package com.techelevator;

public class TellerMachine {
	
	String manufacturer;
	double deposits;
	double withdrawals;
	double balance;
	
	public TellerMachine(String manufacturer, double deposits, double withdrawals) {
		this.manufacturer = manufacturer;
		this.deposits = deposits;
		this.withdrawals = withdrawals;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public double getDeposits() {
		return deposits;
	}

	public double getWithdrawals() {
		return withdrawals;
	}

	public double getBalance() {
		return deposits - withdrawals;
	}
	
	public String toString() {
		return "ATM - " + getManufacturer() + " - " + getBalance();
	}

}
