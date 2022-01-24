package ques3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class BookSortingTitleAuthor implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		// TODO Auto-generated method stub
		int val=(b1.getBookName().toLowerCase().compareTo(b2.getBookName().toLowerCase()));
		if(val==0) {
			val=(b1.getAuthor().toLowerCase().compareTo(b2.getAuthor().toLowerCase()));
		}
		return val;
	}
	
}

public class BookCollection {
	 private String OwnerName;
	 private ArrayList<Book> books;
	 
	 public BookCollection(String OwnerName,ArrayList<Book> books) {
		 super();
		 this.OwnerName=OwnerName;
		 this.books=books;
	 }
	 
	 public ArrayList<Book> getBooks(){
		 return books;
	 }
	 
	 public void setBooks(ArrayList<Book> books) {
		 this.books=books;
	 }
	 
	 public String getOwnerName() {
		 return OwnerName;
	 }
	 
	 public void setOwnerName(String name) {
		 OwnerName=name;
	 }

	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		builder.append("BookCollection [Owner:").append(OwnerName).append("Books List: ").append(books).append("]");
		return builder.toString();
		
	}
	
	public boolean hasBook(Book b) {
		boolean result=false;
		for(Book book:books) {
			if(book.getBookName().equalsIgnoreCase(b.getBookName()) && book.getBookName().equalsIgnoreCase(b.getBookName())) {
				result=true;
				break;
			}
		}
		return result;
	}
	
	public void sort() {
		Collections.sort(books,new BookSortingTitleAuthor());
		System.out.println("Sorted book List: ");
		for(Book book:books) {
			System.out.println(book);
		}
	}
	 
	 
}
