package workshop.account.control;

import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class AccountTest {
	//메인메서드 작성
	// 중간에 단축키 설명
	// 글자 몇개 치다 자동완성 하는 경우 다른 클래스 참조해야하면 자동으로 import가 생성됨
	// 알트시프트엘 : 왼쪽에 타입 완성해주는 변수? 기본 생성자를 만들어줌
	public static void main(String[] args) {
		try {
			Account account = new Account();
			
			account.setCustId("A1100");
			// 계좌번호 작성시 ""는 작성하지 않음. 오류가 난다는듯?
			account.setAcctId("221-22-3477");
			account.deposit(100000);
			
			System.out.println("고객번호= " + account.getCustId());
			System.out.println("계좌번호= " + account.getAcctId());
			System.out.println("잔액= " + account.getBalance());
			
			// 알트 시프트 엘
			Account account2 = new Account("A1105", "221-22-3488", 100000);
			account2.withdraw(50000);
			System.out.println("고객번호= " + account2.getCustId());
			System.out.println("계좌번호= " + account2.getAcctId());
			System.out.println("잔액= " + account2.getBalance());
	
			// tostring: 아규먼트가 있는 생성자를 호출하거나 값을 출력하는 부분을 한꺼번에 호출해도 되지만, 투스트링 메서드를 사용한다.
			// ToString();
			// getClass().getName() + '@' + Integer.toHexString(hashCode())
			// workshop.account.entity.Account@2a139a55
			System.out.println(account2);
		} catch (InsufficientBalanceException e) {
			// TODO : handle exception
			System.err.println("Error 메시지 = " + e.getMessage() + e.getCurrentBalance());
		}

	}
}