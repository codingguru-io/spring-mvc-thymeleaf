package codingguru.controllers;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import codingguru.models.Book;
import codingguru.services.BookService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostConstruct
	public void initBookService() {
		this.bookService.addBook(new Book("Java", "Mr. X", LocalDate.now()));
	}
	
	@GetMapping("/")
	public String getBookList(Model model) {
		model.addAttribute("books", bookService.getBooks());
		return "book-list";
	}
	
	@GetMapping("/book")
	public String getBook(Book book) {
		return "add-book";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") UUID id) {
		this.bookService.deleteBook(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") UUID id, Model model) {
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "update-book";
	}
	
	@PostMapping("/updatebook/{id}")
	public String updateBook(@PathVariable("id") UUID id, @Valid Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "update-book";
		}
		book.setId(id);
		this.bookService.updateBook(book);
		return "redirect:/";
	}
	
	@PostMapping("/savebook")
	public String saveBook(@Valid Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "add-book";
		}
		bookService.addBook(book);
		return "redirect:/";
	}
}
