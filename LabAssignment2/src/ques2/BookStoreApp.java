package ques2;

import java.util.Scanner;

class Book{
	String bookTitle;
	String author;
	String ISBN;
	int noOfCopies;
	
	public Book(String bookTitle,String author,String ISBN,int noOfCopies) {
		this.bookTitle=bookTitle;
		this.author=author;
		this.ISBN=ISBN;
		this.noOfCopies=noOfCopies;
	}
	public void display() {
		System.out.println("Book Details: ");
		System.out.println("Book Title: "+bookTitle);
		System.out.println("Book Author: "+author);
		System.out.println("Book ISBN: "+ISBN);
		System.out.println("Book noOfCopies: "+noOfCopies);
	}
	public String getTitle() {
		return bookTitle;
	}
	public int getQuantity() {
		return noOfCopies;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setQuantity(int count) {
		noOfCopies=count;;
	}
}

class BookStore{
	public Book[] books=new Book[10];
public void initial() {
	Book b=new Book("Maths","XYZ","ABC",10);
	books[0]=b;
	Book b1=new Book("English","mahek","DEF",10);
	books[1]=b1;
	Book b2=new Book("Hindi","Harshdeep","GHI",5);
	books[2]=b2;
	Book b3=new Book("Physics","Rajat","JKL",4);
	books[3]=b3;
	Book b4=new Book("Computer","Sharma","MNO",17);
	books[4]=b4;
	
	System.out.println("Books Added!!");
}
	
	public void cell(String title,int quantity) {
		for(int i=0;i<10;i++) {
			if(books[i].bookTitle==title) {
				books[i].noOfCopies=books[i].noOfCopies-quantity;
				System.out.println("Books Sold");
			}else {
				System.out.println("Book is not available");
			}
		}
	}
	public void order(String isbn,int quantity) {
		for(int i=0;i<10;i++) {
			
			System.out.println("Order");
			if(books[i].getISBN()==isbn) {
				int c=books[i].getQuantity();
				books[i].setQuantity(c+quantity);
				System.out.println("Book Qantity increased");
			}else {
				Book b=new Book("Chemistry","Jain","zys",10);
				books[books.length+1]=b;
				System.out.println("New Book Added!!");
			}
		}
	}
	public void showBooks() {
		for(int i=0;i<books.length;i++) {
			System.out.println("List Of Books: ");
			System.out.println(books.length);
			books[i].display();
		}
	}
	
}
public class BookStoreApp {
	public static void main(String[] args) {
		int ch;
		int exit=1;
		Scanner sc=new Scanner(System.in);
		while(exit==1) {
			System.out.println("Please Select a Option:");
			System.out.println("1.Dispaly    2.Order    3.Sell   0.Exit  9.Initial");
			ch=sc.nextInt();
			BookStore b=new BookStore();
			
			if(ch==1) {
				b.showBooks();
			}else if(ch==9) {
				b.initial();
			}
			else if(ch==2) {
				b.order("abc",5);
			}else if(ch==3) {
				b.cell("ABC", 1);
			}else if(ch==0) {
				System.out.println("Done!!");
				exit=0;
			}else {
				System.out.println("Wrong Input!!");
			}
		}
		
	}
}