package ques3;

import java.util.ArrayList;

public class BookCollectionDemo {
	public static void main(String[] args) {
		ArrayList<Book> books=new ArrayList<Book>();
		Book b1=new Book("Mahek","JAVA","123",3000);
		Book b2=new Book("Harshdeep","Python","456",2000);
		books.add(b2);
		books.add(b1);
		
		BookCollection collection=new BookCollection("Ranbir",books);
		
		System.out.println(collection.hasBook(b1));
		collection.sort();
	}
}
