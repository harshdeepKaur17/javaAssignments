package ques4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Largest {
	static double greatestNumber(ArrayList<Double> arr) {
		PriorityQueue<Double> queue=new PriorityQueue<>(new Comparator<Double>() {

			@Override
			public int compare(Double arg0, Double arg1) {
				
				return Double.compare(arg0, arg1);
			}
			
		});
		
		for(Double num:arr) {
			queue.offer(num);
		}
		System.out.println(queue);
		return queue.poll();
	}
	
	public static void main(String[] args) {
		ArrayList<Double> numbers=new ArrayList<>();
		try(BufferedReader br=new BufferedReader(new FileReader(new File("data.txt")))){
			String line=null;
			while((line=br.readLine())!=null) {
				numbers.add(Double.parseDouble(line));
			}
			System.out.println("Largest Number: "+greatestNumber(numbers));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
