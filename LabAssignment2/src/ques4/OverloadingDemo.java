package ques4;

import java.util.*;

class Student{
	String name;
	String id;
	double grade;
	
	public Student(String name,String id,double grade) {
		this.name=name;
		this.id=id;
		this.grade=grade;
	}
	public Student(String name,String id) {
		this.name=name;
		this.id=id;
	}
	public Student(String id) {
		this.id=id;
	}
	
	public void display() {
		System.out.println("Name: "+name);
		System.out.println("Id: "+id);
		System.out.println("Grade: "+grade);
	}
	
	public void display(int yr) {
		System.out.println("Name: "+name);
		System.out.println("Id: "+id);
		System.out.println("Grade: "+grade);
		System.out.println("Year: "+yr);
	}
}
public class OverloadingDemo {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int val=1;
		while(val==1) {
			System.out.println("Enter name: ");
			String name=sc.nextLine();
			System.out.println("Enter id: ");
			String id=sc.nextLine();
			System.out.println("Enter grade: ");
			double grade=sc.nextDouble();
			System.out.println("Enter year: ");
			int yr=sc.nextInt();
			
			System.out.println("Enter the choice: 1.Create student object   2. Display student info  3.Exit");
			int ch=sc.nextInt();
			
			Student student;
			if(ch==1) {
				if(name !="" && id !="" && grade>0) {
					student=new Student(name,id,grade);
				}else if(grade<0) {
					student=new Student(name,id);
				}else if(name=="") {
					student=new Student(id);
				}
				System.out.println("Created!!");
			}else if(ch==2) {
				if(yr>0) {
					student=new Student("mahek","abc",95);
					student.display(yr);
				}else {
					student=new Student("mahek","abc",95);
					student.display();
				}
			}else if(ch==3) {
				val=0;
			}else {
				System.out.println("Invalid input!!");
			}
		}
		
	}

}
