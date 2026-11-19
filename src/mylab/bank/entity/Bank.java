package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private List<Account> account;
	private int nextAccountNumber;
	
	public Bank() {
		this.account = new ArrayList<Account>();
	}
	
	public String createSavingAccount(String double double) {
		
	}
	
	public String createCheckingAccount(String double double) {
		
	}
	
	public Account findAccount(String) throws AccountNotFoundException {
		
	}
	
	public void deposit(String double) throws AccountNotFoundException {
		
	}
	
	public void withdraw(String double) throws AccountNotFoundException, InsufficientBalanceException {
		
	}
	
	public void transfer(String, String, double) throws AccountNotFoundException, InsufficientBalanceException {
		
	}
	
	public void printAllAccounts() {
		
	}
	
}
