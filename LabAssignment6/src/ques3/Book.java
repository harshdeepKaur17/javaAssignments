package ques3;

public class Book {
	private String author;
	private String bookName;
	private String isbn;
	private double price;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book(String author, String bookName, String isbn, double price) {
		super();
		this.author = author;
		this.bookName = bookName;
		this.isbn = isbn;
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [Name=").append(bookName).append(", author=").append(author).append(", isbn=").append(isbn)
				.append(", price=").append(price).append("]");
		return builder.toString();
	}
	
	
}
