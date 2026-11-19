package mylab.bank.entity;

import workshop.account.exception.InsufficientBalanceException;

public class CheckingAccount extends Account {

	private double withdrawalLimit;

	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}

	public void withdraw (double amount) throws InsufficientBalanceException {
		this.withdrawalLimit = amount;
	}
	
	@Override
	public String toString() {
		return "CheckingAccount [withdrawalLimit=" + withdrawalLimit + "]";
	}

	
	
}
