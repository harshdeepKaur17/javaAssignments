package ques6;

import java.util.*;
class CustomException extends RuntimeException{
	public CustomException(int num) {
		super("Error!!!Input cannot be greater than "+num);
	}
}
public class CustomExceptionDemo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the limit: ");
		int limit=sc.nextInt();
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
				if(num>limit && num!=-1) {
					throw new CustomException(limit);
				}
				
			}catch(InputMismatchException ex) {
				System.out.println("error!!!Enter an integer value!!");
				sc.nextLine();
			}catch(CustomException ex) {
				System.out.println(ex.getMessage());
			}
		}
		System.out.println("Program Executed!!");
	}
	
}
