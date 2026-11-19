package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
	
	private String accountNumber;	//계좌번호
	private String ownerName;		//소유자 이름
	private double balance;			//잔액
	
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
		this.balance += amount;
		System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
	}

	public void withdraw (double amount) throws InsufficientBalanceException {
		if(amount > this.balance) {
			//Exception을 강제로 발생시킴
			throw new InsufficientBalanceException("잔액이 부족합니다.");
			
		}
		
		this.balance -= amount;
		System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
	}

	@Override
	public String toString() {
	
		return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원" ;
	}
	
}
