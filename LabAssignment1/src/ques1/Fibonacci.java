package ques1;

public class Fibonacci {
	 public static void main(String[] args) {
		  int arr[]=new int[20];
		  double avg=0;
		 arr[0]=1;
		 arr[1]=1;
		 for(int i=2;i<20;i++) {
			 arr[i]=arr[i-1]+arr[i-2];
		 }
		 for(int i=0;i<20;i++) {
			 avg=avg+arr[i];
		 }
		 avg=avg/20;
		 System.out.println("Series: ");
		 for(int i=0;i<20;i++) {
			 System.out.print(arr[i]+" ");
		 }
		 System.out.println();
		 System.out.println("Average is: "+avg);
	 }
	}