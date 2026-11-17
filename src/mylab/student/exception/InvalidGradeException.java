package mylab.student.exception;

/* 
 * 5학년 이상은 있을 수 없음 에러를 띄울 때 사용하는 클래스 
 */
public class InvalidGradeException extends Exception {
	
	// 생성자 만들기. 에러와 학년을 받도록
	// 수퍼클래스 사용
	public InvalidGradeException(String message) {
		//부모 클래스의 생성자를 호출한다
		super(message);
	}
	
}
