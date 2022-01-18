package ques1;

import java.io.File;
import java.io.FileInputStream;

public class readFile {
	public static byte[] readContent(File file) {
		byte[] arr=new byte[(int)file.length()];
		try(FileInputStream input=new FileInputStream(file)){
			input.read(arr);
			for(byte a:arr) {
				System.out.println(a);
			}
			System.out.println();
			for(byte a:arr) {
				System.out.println((char)a);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		File file=new File("C:\\Users\\ve00YM336\\Documents\\java_assignment\\LabAssignment4\\src\\file.txt");
		readContent(file);
	}
}
