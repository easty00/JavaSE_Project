package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance ;

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
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
}
