package workshop.person.control;

import java.util.ArrayList;
import java.util.List;

import workshop.person.entity.PersonEntity;

public class PersonManager {
	public static void main(String[] atgs) {
		PersonManager pManager = new PersonManager();
		// PersonEntity 배열 선언 및 생성
		List<PersonEntity> persons = new ArrayList<PersonEntity>(); 	// 리스트 유틸 선택하여 임포트 추가
		// PersonEntity[] persons = new PersonEntity[10];  // 배열 대신 어레이리스트 사용 
		pManager.fillPersons(persons);
		//출력
		pManager.showPersons(persons);
		
		char gender = '여';
		System.out.print("성별" + gender + " 은(는) ");
		System.out.println(" " + pManager.findByGender(persons, gender) + " 명 ");
		
		String name = "김하늘";
		pManager.showPerson(persons, name);
	}
	
	//PersonEntity 배열에 값을 채워넣는 메서드 
	// persons 의 타입인 PersonEntity를 넣어줌 
	public void fillPersons(List<PersonEntity> persons) {
		persons.add(new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932"));
		persons.add(new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932"));
		persons.add(new PersonEntity("박영수","7503111233201", "서울 성북구", "02-887-1542"));
		persons.add(new PersonEntity("나인수","7312041038988", "대전 유성구", "032-384-2223"));
		persons.add(new PersonEntity("홍정수","7606221021341", "서울 양천구", "02-158-7333"));
		persons.add(new PersonEntity("이미숙","7502142021321", "서울 강서구", "02-323-1934"));
		persons.add(new PersonEntity("박성구","7402061023101", "서울 종로구", "02-308-0932"));
		persons.add(new PersonEntity("유성미","7103282025101", "서울 은평구", "02-452-0939"));
		persons.add(new PersonEntity("황재현","7806231031101", "인천 중구", "032-327-2202"));
		persons.add(new PersonEntity("최철수","7601211025101", "인천 계양구", "032-122-7832"));
	}
	
	//PersonEntity 배열의 값을 출력하는 메서드
	public void showPersons(List<PersonEntity> persons) {
		// 이름, 성별, 전화번호 순으로 출력되도록 만들기. 파이썬의 print()
		for (PersonEntity person : persons) {
			// for 문이 반복하며 PersonEntity 의 사람을 한명씩 반복해서 꺼냄
			System.out.println("[이름] " + person.getName() + "\t [성별] " + person.getGender() + "\t [주소] " + person.getAddress());
		}
	}
	
	// 남녀가 각자 몇인지 세야함
	// 입력받은 성별값과 일치하는 PersonEntity 객체 건수를 찾는 메서드
	public int findByGender(List<PersonEntity> persons, char gender) {
		int personCnt = 0;
		for (PersonEntity person : persons) {
			if(person.getGender() == gender) {
				personCnt++;
			}
		}
		return personCnt;
	}
	
	// 입력 받은 이름 값과 일치하는 PersonEntity 객체를 찾아서 세부정보를 출력하는 메서드
	public void showPerson(List<PersonEntity> persons, String name) {
		// for loop 돌림
		for (PersonEntity person : persons) {
			if(person.getName().equals(name)) {
				System.out.println("[이름] " + person.getName());
				System.out.println("[성별] " + person.getGender());
				System.out.println("[전화번호] " + person.getPhone());
				System.out.println("[주소] " + person.getAddress());
				// 찾으면 바로 빠진다
				break;
			}
		}
	}
	
	
}
