package ques4;

import java.util.*;
public class ExceptionDemo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=0;
		while(num!=-1) {
			num=0;
			try {
				System.out.println("Please enter a number or enter -1 to exit");
				num=sc.nextInt();
				if(num!=-1) {
					if(num%2==0) {
						System.out.println("Even number");
					}else {
						System.out.println("Odd number");
					}
					
				}
				
			}catch(InputMismatchException ex) {
				System.out.println("error!!!Enter an integer value!!");
				sc.nextLine();
			}
		}
		System.out.println("Program Executed!!");
	}
}
