package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	private String name;
	private List<Book> books;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<>();
	}

	// 도서를 추가하는 메서드
	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
	}

	// 제목, 저자, ISBN으로 도서를 검색하는 메서드
	public Book findBookByTitle(String title) {
		for (Book b : books) {
			if (b.getTitle().equals(title)) {
				return b;
			} else {
				
			}
		}return null;
	}
	public List<Book> findBooksByAuthor(String author) {
		List<Book> b = new ArrayList<Book>();
			for (Book e : books) {
				if (e.getAuthor().equals(author)) {
					b.add(e);
				} else {
					
				}
			} return b;
	}
	
	public Book findBookByISBN(String isbn) {
		for (Book b : books) {
			if (b.getIsbn().equals(isbn)) {
				return b;
			} else {
				
			}
		}return null;
	}

	// ISBN으로 도서를 대출하거나 반납하는 메서드
	public boolean checkOutBook(String isbn) {
		Book b = findBookByISBN(isbn);
		if (b == null) {
			return false;
		}
		return b.checkOut();
	}
	
	public boolean returnBook(String isbn) {
	    Book b = findBookByISBN(isbn);
	    if (b == null) {
	        return false;
	    }
	    b.returnBook();
	    return true;
	}
	
	// 대출 가능한 도서 목록이나 전체 도서 목록을 반환하는 메서드
	public List<Book> getAvailableBooks() {
		List<Book> b = new ArrayList<Book>();
		for (Book e : books) {
			if (e.isAvailable() == true) {
				b.add(e);
			} else {
				
			}
		} return b;
	}
	
	public List<Book> getAllBooks() {
		return books;		
	}
	
	// 도서 수량 관련 정보를 반환하는 메서드
	public int getTotalBooks() {
		return books.size();
	}
	public int getAvailableBooksCount() {
		return getAvailableBooks().size();
	}
	public int getBorrowedBooksCount() {
		return books.size() - getAvailableBooks().size();
	}
	
	
	public String getName() {
		return name;
	}

}	
	
