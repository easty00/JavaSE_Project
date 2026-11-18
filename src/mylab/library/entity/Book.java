package mylab.library.entity;

public class Book {
	//속성
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	public Book() {
		isAvailable = true;
	}
	
	//생성자
	public Book(String title, String auther, String isbn, int publishYear) {
		super();
		this.title = title;
		this.author = auther;
		this.isbn = isbn;
		this.publishYear = publishYear;
		isAvailable = true;
	}
	
	
	// 메서드
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuther() {
		return author;
	}
	public void setAuther(String auther) {
		this.author = auther;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public boolean checkOut() {
		if (isAvailable == true) {
			isAvailable = false;
			return true;
		} else {
			return false;
		}
			
	}
	
	public void returnBook() {
		isAvailable = true;
	}
	
	@Override
	public String toString() {
		String status;
		
		if (isAvailable == true) {
			status = "가능";
		} else {
			status = "대출 중";
		}
			
		return "책 제목: " + title + "\t 저자: " + author + "\t  ISBN: " + isbn + "\t 출판년도: " + publishYear + "\t 대출 가능 여부: " + status;
	}
	
}
