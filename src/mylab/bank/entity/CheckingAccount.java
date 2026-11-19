package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

// 인출 한도가 있는 체킹계좌
public class CheckingAccount extends Account {

	private double withdrawalLimit;

	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}
	
	//출금한도
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	@Override
	public void withdraw (double amount) throws InsufficientBalanceException {
		if(withdrawalLimit < amount) {
			throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
		}
		
		super.withdraw(amount);

	}
	
	@Override
	public String toString() {
		return super.toString() + ", 출금 한도: " + withdrawalLimit + "원";
	}

	
	
}
