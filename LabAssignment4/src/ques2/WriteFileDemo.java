package ques2;

import java.io.*;
import java.util.*;
public class WriteFileDemo {
	private static void writeData(File file) {
		try(BufferedWriter writer =new BufferedWriter(new FileWriter(file));Scanner sc=new Scanner(System.in)){
			String writeToFile="";
			System.out.println("Enter text to write in file");
			writeToFile=sc.nextLine();
			writer.write(writeToFile);
			System.out.println("\nFile Written successfully!!");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Cannot write to file!!");
		}
	}
	
	private static String readData(File file) {
		String line=null;
		try(BufferedReader reader=new BufferedReader(new FileReader(file))){
			while((line=reader.readLine())!=null) {
				System.out.println(line);
			}
			System.out.println("Reading complete!!");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Cannot read from file!!");
		}
		return line;
	}
	
	public static void main(String[] args) {
		File file=new File("test.txt");
		writeData(file);
		readData(file);
	}
}
