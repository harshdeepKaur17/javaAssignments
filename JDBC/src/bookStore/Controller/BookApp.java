package bookStore.Controller;

import java.sql.*;
import java.util.List;

import bookStore.Model.Exception.DataAccessException;
import bookStore.Model.Service.BookService;
import bookStore.Model.Service.BookServiceImpl;
import bookStore.Model.persistence.Book;
import java.util.Properties;
import java.util.Scanner;


public class BookApp {

	
	public static void main(String[] args) {

		BookService bookService = new BookServiceImpl();
		System.out.println("printing all records...");
		printAllBooks(bookService);
		
		Date date=new Date(11,01,2003);
		Book book1=new Book("Gary","478dhh",4000.0, "Core Java",date);
		bookService.addBook(book1);
		
		Scanner in=new Scanner(System.in);
		System.out.println("enter the book id");
		int bookId=in.nextInt();
		Book book2=bookService.getBookById(bookId);
		System.out.println(book2);
		
		Date date1=new Date(12, 05, 2000);
		Book book3=new Book (2," Ketty"," wqe344", 5000 ,"Java application" ,date1);
		bookService.updateBook(book3);
		
		System.out.println("Enter bookid you want to delete");
		int bookId1=in.nextInt();
		bookService.removeBook(bookId1);
		
		in.close();

	}

	private static void printAllBooks(BookService bookService) {
		try {
			List<Book> books1 = bookService.getAllBooks();
			for (Book book : books1) {
				System.out.println(book);
			}
		} catch (DataAccessException ex) {

			ex.printStackTrace();
		}

	}
}