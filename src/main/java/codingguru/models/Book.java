package codingguru.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Book {
	private UUID id;
	@NotBlank(message = "Title is mandatory")
	private String title;
	@NotBlank(message = "Author is mandatory")
	private String author;
	@NotNull(message = "Published Date is mandatory")
	private LocalDate publishedDate;
	
	public Book(String title, String author, LocalDate publishedDate) {
		this.title = title;
		this.author = author;
		this.publishedDate = publishedDate;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publishedDate=" + publishedDate + "]";
	}
}
