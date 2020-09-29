package com.techelevator;

public class SavingsAccount extends BankAccount{
	
	//2-arg ctr
	public SavingsAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
	}

	//3-arg ctr
	public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
	}
	
	@Override   // Overriding withdraw in BankAccount Class
	public int withdraw(int amountToWithdraw) {
		
		int balance = getBalance() - amountToWithdraw;
		
		if(amountToWithdraw > getBalance())
		{
			return getBalance();
		}
		if(balance < 150 && balance >= 0)
		{
			super.withdraw(amountToWithdraw + 2);
			return getBalance();
		}
		else if(balance > 150)
		{
			super.withdraw(amountToWithdraw);
			return getBalance();
		}
		
		return balance;


	}

}
