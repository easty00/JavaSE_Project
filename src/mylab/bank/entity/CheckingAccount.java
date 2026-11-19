package mylab.bank.entity;

import workshop.account.exception.InsufficientBalanceException;

// 인출 한도가 있는 체킹계좌
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
		return "출금 한도를 초과했습니다. 한도: " + getBalance() + "원";
	}

	
	
}
