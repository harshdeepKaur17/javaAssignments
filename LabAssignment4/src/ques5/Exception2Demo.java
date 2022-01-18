package ques5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception2Demo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=0;
		while(num!=-1) {
			num=0;
			try {
				System.out.println("Please enter a number or enter -1 to exit");
				num=sc.nextInt();
				if(num!=-1 && num<100) {
					if(num%2==0) {
						System.out.println("Even number");
					}else {
						System.out.println("Odd number");
					}
					
				}
				if(num>100 && num!=-1) {
					throw new Exception();
				}
				
			}catch(InputMismatchException ex) {
				System.out.println("error!!!Enter an integer value!!");
				sc.nextLine();
			}catch(Exception ex) {
				System.out.println("Error!! number greater than 100");
			}
		}
		System.out.println("Program Executed!!");
	}
}
