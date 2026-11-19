package mylab.bank.entity;

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
		return applyinterest;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + "]";
	}
	
}
