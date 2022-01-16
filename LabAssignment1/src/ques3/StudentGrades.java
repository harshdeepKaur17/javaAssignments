package ques3;

import java.util.*;
public class StudentGrades {
 public static void main(String[] args) {
	 int numStudents;
	 System.out.println("Enter the number of students:");
	 Scanner sc=new Scanner(System.in);
	 numStudents=sc.nextInt();
	 double avg=0;
	 int i=0;
	 while(i<numStudents) {
		 System.out.println("Enter grade for student "+(i+1));
		 double marks=sc.nextDouble();
		 if(marks>0 && marks<=100) {
			 i++;
			 avg=avg+marks;
		 }else {
			 System.out.println("Invalid Grade!! Please Try again!!");
		 }
	 }
	 System.out.println("Average Marks: "+avg/numStudents);
 }
}
