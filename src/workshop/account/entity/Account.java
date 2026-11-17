package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {
	//public class Account extend Object 의 줄임이다. 숨겨져있음.
	private String custId;
	private String acctId;
	private int balance ;
	
	public Account() {
		
	}

	public Account(String custId, String acctId, int balance) {
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}

	//Method 선언
	// setacct .. 에 컨트롤 스페이스바를 눌러 낱개로 반복문 작성가능
	// 한꺼번에 하는 방법 (소스-게터세터-반복문 원하는 함수들 선택해서 만들어낼 수 있음. 정해진 규칙이 있기 때문)
	// 알트 키로 블록 씌운 문장을 이동시킬 수 있음
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	public int getBalance() {
		return balance;
	}
	
	// 4번. 2개 메서드 추가
	public void deposit(int amount) {
		// 풀어씀. 아래가 축약 : this.balance = this.balance + amount;
		this.balance += amount;
	}

	// 익셉션 처리
	public void withdraw(int amount) throws InsufficientBalanceException {
		if(amount > this.balance) {
			//Exception을 강제로 발생시킴
			throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액은 = ", this.balance);
			
		}
		
		this.balance -= amount;
	}
	
	// 하나 끝. 어카운트 테스트 클래스 작성해야함.
	
	@Override
	public String toString() {
		return "Account [custId=" + custId + ", acctId=" + acctId + ", balance=" + balance + "]";
	}
	
}
