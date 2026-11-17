# LG CNS InspireCamp 7기 백엔드 수업 - Java

## STS 실습 내역

### 2026-11-18 ::: [실습1] 학생 정보 (Student) 클래스 구현
  - 소요시간 : 약 1시간
  - 어떻게 풀었는지
      - 수업 중 완성한 Account 예제를 참고하였다.
      - 학생정보의 클래스 다이어그램을 참고하여 필드를 작성하였고, 오늘 배운 generate Getters and Setters 를 이용하여 getter와 setter를 작성하였다.
      - Account에서 사용한 deposit 와 withdraw는 없는 것 같아 다이어그램대로 getGrade 에 void throws InvalidGradeException을 작성하였다.
      - 학년이 1~4 사이의 값이므로 0이하 또는 5 이상이 나와선 안된다고 생각하여 grade < 1 || grade > 4 를 넣었다.
      - 하지만 에러가 나왔다. (에러는 도중에 캡쳐등을 하지 않았다)
      - 확인 한 결과 캐치로 받기 위해 보내야 할 데이터를 try로 감싸지 않았었기에 수정하였다.
      - 하지만 여전히 되지 않았고, AI 에게 힌트를 요청한 결과 Exception에 문제가 있음을 알았다.
      - Account를 따라 만드느라 내 Exception 클래스 안에는 currentGrade 가 있었고, 이걸 받을 곳이 없었다.
      - 그리고 AI가 Exception 안에 String 만 들어간다고 조언하여 메시지 외에는 아무것도 없도록 군더더기를 지웠다.
      - 이후 여전히 에러였다.
      - AI는 생성자에도 throws 를 붙여야 한다고 조언했다. 그제서야 보니 다이어그램에도 생성자에 throws가 붙어있음을 깨달았다. 나는 이게 딱히 의미 없는줄 알고있었다.
      - 이후 생성자에 관련한 AI 와의 대화를 아래에 첨부한다.


## Student 생성자에 throws가 붙는 이유
<details>
<summary><b>펼쳐 보기</b></summary>
---

### Q1. 생성자의 throws가 뭔지 모르겠어

#### throw vs throws
| | 위치 | 뜻 |
|---|---|---|
| `throw` | 메서드 안 | 예외를 실제로 던짐 |
| `throws` | 메서드 선언부 `)` 뒤 | "이 메서드는 예외를 던질 수 있다"고 미리 알림 |

#### 생성자에 throws가 필요한 이유
- 생성자 안에서 `setGrade(grade)`를 호출함
- setGrade는 `throws InvalidGradeException`이 선언된 메서드
- 예외를 던질 수 있는 메서드를 호출하는 쪽은 둘 중 하나를 해야 함
  1. 직접 처리 → try-catch
  2. 호출한 쪽으로 넘기기 → throws
- 둘 다 안 하면 컴파일 에러 (InvalidGradeException이 Exception을 상속한 checked 예외이기 때문)

```java
public Student(String studentId, String name, String major, int grade) throws InvalidGradeException {
    setStudentId(studentId);
    setName(name);
    setMajor(major);
    setGrade(grade);
}
```

#### 생성자에서 catch하지 않고 넘기는 이유
- 생성자가 직접 잡으면 grade가 0인 학생 객체가 그대로 만들어짐
- 호출한 StudentTest는 문제가 생긴 걸 알 수 없음
- 넘기면 예외가 아래 순서로 전달되어 StudentTest에서 메시지 출력 가능

```
setGrade(throw) → 생성자(throws) → StudentTest(main)에서 catch → 메시지 출력
```

---

### Q2. account 예제와 달리 생성자도 throw를 던지는 이유가, account는 추가 메서드로 exception을 처리하지만 얘는 setGrade가 처리해서야?

→ 거의 맞음. 정확한 기준은 **"생성자가 예외를 던지는 메서드를 호출하느냐"**

#### Account 예제와의 차이
- Account: 생성자는 `this.balance = balance;`로 바로 저장하고, 예외는 출금 메서드에서만 발생
  → 생성자가 예외 던지는 메서드를 부르지 않으므로 throws 불필요
- Student: 생성자가 `setGrade(grade)`를 호출
  → 생성 도중에도 예외가 날 수 있으므로 throws 필요

#### 용어 정리: "처리"와 "던지기"는 다름
- 예외에서 **처리**는 catch로 잡는 것
- setGrade는 예외를 처리하는 게 아니라 **던지는** 쪽
  - 던지기(throw/throws): setGrade, 생성자
  - 처리하기(catch): StudentTest

#### 생성자에서 setGrade를 호출하는 이유
- 생성자에서 `this.grade = grade;`로 바로 저장하면 throws는 필요 없음
- 하지만 `new Student(..., 5)`처럼 처음 만들 때는 검사를 안 거쳐서 5학년 학생이 생성됨
- 학년은 처음 만들 때도 1~4여야 하므로 생성자도 setGrade의 검사를 거치게 함
  → 그 결과 생성자에도 throws가 붙음
  
</details>
