package codingguru.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import codingguru.models.Book;

@Service
public class BookService {
	private List<Book> books = new ArrayList<Book>();
	
	public void addBook(Book book) {
		book.setId(UUID.randomUUID());
		books.add(book);
	}
	
	public void updateBook(Book book) {
		for(int i=0; i<books.size(); i++) 
			if(books.get(i).getId().equals(book.getId())) {
				books.set(i, book);
				break;
			}
	}
	
	public void deleteBook(UUID bookId) {
		for(int i=0; i<books.size(); i++) 
			if(books.get(i).getId().equals(bookId)) {
				books.remove(i);
				break;
			}
	}
	
	public List<Book> getBooks() { 
		return this.books; 
	}
	
	public Book getBookById(UUID bookId) {
		return this.books.stream().filter(book -> book.getId().equals(bookId)).findFirst().get();
	}
}
