package ques4;

class ArrayCopy{
	public int[] copyOf(int a[]) {
		int temp[]=new int[a.length];
		for(int i=0;i<a.length;i++) {
			temp[i]=a[i];
		}
		return temp;
	}
}
public class CopyArray {
 public static void main(String[] args) {
	 ArrayCopy arr=new ArrayCopy();
	 int a[]= {4,5,6,8,2,1};
	int b[]=arr.copyOf(a);
	System.out.println("Copied Array:");
	for(int i=0;i<a.length;i++) {
		System.out.print(" "+b[i]);
	}
 }
}
