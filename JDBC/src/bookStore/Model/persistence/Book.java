package bookStore.Model.persistence;

import java.sql.Date;

public class Book {
	private int id;
	private String author;
	private String isbn;
	private double price;
	private String title;
	private Date date;

	public Book() {

	}

	public Book(int id, String author, String isbn, double price, String title, Date date) {
		super();
		this.id = id;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.title = title;
		this.date = date;
	}

	public Book(String author, String isbn, double price, String title, Date date) {

		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.title = title;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", isbn=" + isbn + ", price=" + price + ", title=" + title
				+ ", date=" + date + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}