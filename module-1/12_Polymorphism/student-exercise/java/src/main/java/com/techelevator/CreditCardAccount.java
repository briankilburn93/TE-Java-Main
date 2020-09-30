package com.techelevator;

/**
 * CreditCardAccount
 */
public class CreditCardAccount implements Accountable {
	private String accountHolder;
	private String accountNumber;
	private int debt = 0;
	
/*******************************************************************
 * Place the code for  your CreditCard class here
 *******************************************************************/
public CreditCardAccount (String accountHolder, String accountNumber) {
	this.accountHolder = accountHolder;
	this.accountNumber = accountNumber;
}

    public int getBalance() {
    	//***************************************************************
    	// This should return the negative of the debt data member
    	//***************************************************************
    	
        return -debt;
    }

	public String getAccountHolder() {
		return accountHolder;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public int getDebt() {
		return debt;
	}
	
	public int pay(int amountToPay) {
		debt = this.getBalance() - amountToPay;
		return debt;
	}
	
	public int charge(int amountToCharge) {
		debt = this.getBalance() + amountToCharge;
		return debt;
	}

}