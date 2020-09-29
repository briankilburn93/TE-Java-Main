package com.techelevator;

public class CheckingAccount extends BankAccount{
	
	//2-arg ctr
	public CheckingAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
	}
	
	//3-arg ctr
	public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
		
		balance = getBalance();
	}
	
	@Override   // Overriding withdraw in BankAccount Class
	public int withdraw(int amountToWithdraw) {
		
		//if
		
		int balance = getBalance() - amountToWithdraw;
		
		if(balance > 0)
		{
			super.withdraw(amountToWithdraw);
			return getBalance();
		}
		else if(balance < 0 && balance >= -100)
		{
			//amountToWithdraw = amountToWithdraw - 10;
			super.withdraw(amountToWithdraw + 10);
			return getBalance();
		}
		
		return getBalance();

	}

}
