package workshop.animal.entity;

public class Cat extends Animal implements Pet {
	private String name;
	
	public Cat(String name) {
		super(4);
		this.name = name;
		
	}
	
	public Cat() {
		// 설명서에 먼저 만든 생성자를 가져오라고 함
		this("");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public void play() {
		System.out.println("고양이는 장화를 신고 놀아요!");

	}

	@Override
	public void eat() {
		System.out.println("고양이는 물고기를 먹어요!");
		// TODO Auto-generated method stub
		
	}

}
