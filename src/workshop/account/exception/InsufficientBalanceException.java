package workshop.account.exception;

/* 
 * Account의 잔액(balance)가 부족할 때 사용되는 사용자정의 Exception 클래스 
 */
public class InsufficientBalanceException extends Exception {
	// 현재잔액
	private int currentBalance
	
	// 생성자 만들기. 에러와 커렌트밸런스를 받도록
	// 유징필드, 수퍼클래스 사용
	public InsufficientBalanceException(String message, int currentBalance) {
		//부모 클래스의 생성자를 호출한다
		super(message);
		this.currentBalance = currentBalance;
	}
	
	// 게터 메서드 자동완성
	public int getCurrentBalance() {
		return currentBalance;
	}
	
}
