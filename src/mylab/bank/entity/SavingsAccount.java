package mylab.bank.entity;

//기본 이자율이 있는 저축계좌
public class SavingsAccount extends Account {
	
	private double interestRate;

	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void applyInterest() {
		double Account.getBalance();
		balance b 
	}

	@Override
	public String toString() {
		return "출금 한도를 초과했습니다. 한도: " + getBalance() + "원";
	}
	
}
