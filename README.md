# LG CNS InspireCamp 7기 백엔드 수업 - Java

## 폴더 구성

| 경로 | 내용 |
|---|---|
| `src/chapter1` ~ `src/chapter6` | 수업 시간 예제 (문법, 제어문, OOP, 배열, 상속/추상/인터페이스, 컬렉션) |
| `src/workshop` | 수업 워크숍 예제 (account, animal, book, person) |
| `src/basic` | 단계별 복습 예제 (문법 → 메서드 → 클래스 → 상속 → 다형성 → 예외 → 컬렉션 → 계층 구조) |
| `src/mylab` | 실습 과제 |

## 실습 진행 현황

| 실습 | 주제 | 패키지 | 제출 기한 | 상태 |
|---|---|---|---|---|
| 실습1 | 학생 정보(Student) 클래스 - 캡슐화, 사용자 정의 예외 | `mylab.student` | 11/18(수) | 완료 |
| 실습2 | 도서관 관리 시스템 - 클래스 협력, List 컬렉션 | `mylab.library` | 11/19(목) | 완료 |
| 실습3 | 은행 계좌 관리 시스템 - 상속, 오버라이딩, 예외 계층 | `mylab.bank` | 11/20(금) | 완료 |
| 실습4 | 출판물 관리와 쇼핑카트 - 다형성 | - | - | 예정 |

---

## STS 실습 내역

### 2026-11-18 ::: [실습1] 학생 정보 (Student) 클래스 구현

- 파일
  - `mylab.student.entity.Student`
  - `mylab.student.control.StudentTest`
  - `mylab.student.exception.InvalidGradeException`
- 소요시간 : 약 2시간
- 어떻게 풀었는지
  - 수업 중 완성한 Account 예제를 참고하였다.
  - 학생정보의 클래스 다이어그램을 참고하여 필드를 작성하였고, 오늘 배운 generate Getters and Setters 를 이용하여 getter와 setter를 작성하였다.
  - Account에서 사용한 deposit 와 withdraw는 없는 것 같아 다이어그램대로 setGrade 에 void throws InvalidGradeException을 작성하였다.
  - 학년이 1~4 사이의 값이므로 0이하 또는 5 이상이 나와선 안된다고 생각하여 grade < 1 || grade > 4 를 넣었다.
  - 하지만 에러가 나왔다. (에러는 도중에 캡쳐등을 하지 않았다)
  - 확인 한 결과 캐치로 받기 위해 보내야 할 데이터를 try로 감싸지 않았었기에 수정하였다.
  - 하지만 여전히 되지 않았고, AI 에게 힌트를 요청한 결과 Exception에 문제가 있음을 알았다.
  - Account를 따라 만드느라 내 Exception 클래스 안에는 currentGrade 가 있었고, 이걸 받을 곳이 없었다.
  - 그리고 AI가 Exception 안에 String 만 들어간다고 조언하여 메시지 외에는 아무것도 없도록 군더더기를 지웠다.
  - 이후 여전히 에러였다.
  - AI는 생성자에도 throws 를 붙여야 한다고 조언했다. 그제서야 보니 다이어그램에도 생성자에 throws가 붙어있음을 깨달았다. 나는 이게 딱히 의미 없는줄 알고있었다.
  - 이후 생성자에 관련한 AI 와의 대화를 아래에 첨부한다.

#### Student 생성자에 throws가 붙는 이유

<details>
<summary><b>펼쳐 보기</b></summary>

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

---

### 2026-11-19 ::: [실습2] 도서관 관리 시스템 구현하기

- 파일
  - `mylab.library.entity.Book`
  - `mylab.library.entity.Library`
  - `mylab.library.control.LibraryManagementSystem`
- 소요시간 : 약 6시간
- 어떻게 풀었는지
  - 강의때 풀었던 예제를 참고하였다. 이후 에러를 고치지 못하게 된 후로 AI에게 힌트를 받으며 작성하고 검수받기를 반복하였다.
  - Book → Library → LibraryManagementSystem 순서로 작성했다.
  - **Book**
    - `isAvailable()` getter 안을 비워 둬서 에러가 났다. 반환 타입을 적으면 반드시 return 해야 한다.
    - `checkOut()`에서 if 문법(조건은 소괄호, 할 일은 중괄호)과 `=`(값 넣기) / `==`(같은지 비교)의 차이를 헷갈렸다.
    - checkOut에는 **책 상태 바꾸기**(`isAvailable = false`)와 **대답하기**(`return true`)라는 서로 다른 일이 두 개 있다는 걸 이해했다. 대출에 성공하면 상태는 false, 대답은 true로 반대가 된다.
    - `toString()`에서 println을 썼다가 에러가 났다. println은 화면에 출력만 하고, return은 호출한 쪽에 값을 돌려준다.
    - 대출 상태를 "가능 / 대출 중"으로 보여주려고 String 변수에 if로 글자를 넣고 마지막에 붙였다. if 안에서 return을 쓰면 메서드가 바로 끝나서 아래 줄이 실행되지 않는다.
  - **Library**
    - books 필드를 String에서 `List<Book>`으로 바꾸고, 생성자에서 `new ArrayList<>()`로 빈 목록을 만들었다. 생성자 안에서 앞에 타입을 다시 붙이면 필드가 아니라 새 지역 변수가 생긴다.
    - 하나 찾기(제목, ISBN): for-each로 한 권씩 꺼내 getter로 값을 꺼낸 뒤 `.equals()`로 비교했다. 책 객체를 문자열과 바로 비교하면 항상 false다. 못 찾으면 for **밖**에서 `return null`.
    - 여러 개 모으기(저자, 대출 가능 목록): 새 목록을 만들고, 조건에 맞으면 `add`, for 밖에서 목록을 return 했다.
    - 개수는 `size()`로 구했고, 대출 중인 권수는 전체 − 대출 가능으로 계산했다.
    - 대출/반납: ISBN으로 책을 찾고 null이면 false. 대출은 Book의 `checkOut()` 대답을 그대로 return, 반납은 Book의 `returnBook()`이 void라서 호출한 뒤 따로 `return true` 했다.
  - **LibraryManagementSystem**
    - main 안에 메서드를 넣어서 에러가 났다. 메서드 안에는 메서드를 만들 수 없어서 밖으로 옮겼다.
    - main이 static이라서 main에서 부르는 테스트 메서드들도 static으로 바꿨다.
    - `System.out.println(book)`처럼 객체를 출력하면 toString이 자동으로 호출된다.
    - 목록을 통째로 println하면 `[ ]`가 붙어서, for로 한 권씩 출력했다.
    - books는 Library의 private 필드라 LMS에서 바로 쓸 수 없어서 `library.getAvailableBooks()`처럼 Library에게 받아 와서 썼다.

---

### 2026-11-20 ::: [실습3] 은행 계좌 관리 시스템 구현하기

- 파일
  - 제공 코드 : `mylab.bank.exception` (AccountNotFoundException, InsufficientBalanceException, WithdrawalLimitExceededException), `mylab.bank.control.BankDemo`
  - 직접 작성 : `mylab.bank.entity` (Account, SavingsAccount, CheckingAccount, Bank)
- 소요시간 : 약 5시간
- 참고한 예제
  - `src/workshop/account` : 수업 Account 예제 (withdraw의 throw)
  - `src/basic/step06_inheritance/Manager.java` : super 생성자, 오버라이딩, `super.toString()`
  - `src/basic/step10_layer/control/MemberManager.java` : 목록 관리 클래스 (번호 자동 생성, 찾기 + 예외, 전체 출력)
- 어떻게 풀었는지
  - 수업 예제를 참고하였지만 부족하다고 느꼈다. AI에게 파일을 주어 참고할 수 있는 파일을 찾아주기를 요청하였다. 이후 basic의 예제 파일 몇가지와 실제 수업중의 예제, 그리고 숙제로 작성하였던 실습 문제들을 참고하고, 도저히 안되는 부분은 AI에게 힌트를 받았다.
  - 다음 예제에서 사용될 것이 많다는 AI의 조언에 메서드 하나를 풀 때마다 알기 쉽게 원리를 설명해주기를 부탁하였고, 실습코드 작성 전 원리를 한번 읽은 후 작성하기를 반복하였다.
  - **Account (추상 클래스)**
    - throw 할 때 `new`를 빠뜨렸다. 예외도 객체라서 `throw new ...`로 만들어서 던진다.
    - 제공된 예외 클래스는 생성자가 메시지 하나만 받아서, 수업 예제처럼 잔액을 같이 넘기지 않았다.
    - 입금/출금 후 Sample Run처럼 금액과 현재 잔액을 출력하게 했다.
  - **상속에서 이해한 것**
    - `extends`로 부모의 필드와 메서드를 물려받는다. 공통 기능(입금, 출금)은 Account에 한 번만 쓰고, 자식은 추가 기능만 쓴다.
    - 부모의 private 필드(balance)는 물려받아도 자식이 직접 쓸 수 없다. `getBalance()`, `deposit()` 같은 public 메서드를 통해서 쓴다.
    - `super(...)`는 부모 생성자 호출, `super.메서드()`는 부모 버전 메서드 호출이다.
    - abstract 클래스는 `new Account(...)`로 직접 만들 수 없고 자식으로만 만든다.
  - **SavingsAccount**
    - 이자 = `getBalance() * interestRate`, 그 금액을 물려받은 `deposit()`으로 입금했다.
    - toString은 `super.toString()` 뒤에 이자율을 붙였다. BankDemo가 이자율을 0.03으로 넘겨서 100을 곱해 3.0%로 보여줬다.
  - **CheckingAccount**
    - withdraw를 오버라이딩했다. 한도를 넘으면 WithdrawalLimitExceededException을 던지고, 아니면 `super.withdraw(amount)`로 잔액 검사와 출금은 부모에게 맡겼다.
    - 매개변수 이름을 필드와 같은 withdrawalLimit으로 바꿨다가 필드(진짜 한도)가 가려졌다. 매개변수는 amount, 필드는 withdrawalLimit으로 나눴다.
    - `getBalance() -= amount`처럼 메서드가 돌려준 값을 바꿔서는 잔액이 바뀌지 않는다. 잔액은 Account 안에서만 바꿀 수 있다.
    - WithdrawalLimitExceededException은 InsufficientBalanceException의 자식이라, throws에는 부모 예외만 적어도 된다.
  - **Bank**
    - 계좌번호는 `"AC" + (nextAccountNumber++)`로 만들었다. `++`는 값을 쓴 다음 1을 올린다.
    - `List<Account>`에 SavingsAccount와 CheckingAccount를 같이 담을 수 있다. 부모 타입 목록에 자식 객체를 넣을 수 있기 때문이다.
    - findAccount는 못 찾으면 null 대신 AccountNotFoundException을 던진다. 그래서 deposit, withdraw에서는 null 검사 없이 "찾기 + 시키기" 두 줄로 끝난다.
    - transfer는 두 계좌를 먼저 다 찾고, 출금을 입금보다 먼저 했다. 순서가 반대면 실패했을 때 돈이 사라지거나 생겨난다.
    - 상자 타입이 Account여도 실제 객체가 CheckingAccount면 CheckingAccount의 withdraw가 불린다. printAllAccounts에서도 같은 println인데 계좌 종류마다 다른 toString이 실행된다.
