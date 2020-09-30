package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * BankCustomer
 */
public class BankCustomer {

    private List<Accountable> accounts = new ArrayList<>();   // List of Accountable objects
    
    private String name;
    private String address;
    private String phoneNumber;
    
    public BankCustomer() {
    	
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Accountable[] getAccounts() {
		return accounts.toArray(new Accountable[accounts.size()]);
	}
	
	public void addAccount(Accountable newAccount) {
		accounts.add(newAccount);
	}
		
	
	public boolean isVip() {
		int sum = 0;
		for(Accountable n: accounts) {
			sum = sum + n.getBalance();
		}
		if(sum >= 25000) {
			return true;
		}
		else
		{
			return false;
		}
	}
    
}