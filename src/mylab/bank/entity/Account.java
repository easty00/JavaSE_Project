package mylab.bank.entity;

import workshop.account.exception.InsufficientBalanceException;

public abstract class Account {
	
	private String accountNumber; 
	private String ownerName;
	private double balance;
	
	public Account(String accountNumber, String ownerName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		this.balance = amount;
	}

	public void withdraw (double amount) throws InsufficientBalanceException {
		this.balance = amount;
	}

	@Override
	public String toString() {
		return toString();
	}
	
	
	
}
