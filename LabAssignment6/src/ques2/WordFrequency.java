package ques2;

import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordFrequency {
	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		try {
			BufferedReader br=new BufferedReader(new FileReader("file.txt"));
			String line=null;
			
			while((line=br.readLine()) != null) {
				String tokens[]=line.split(" ");
				for(String token:tokens) {
					Integer freq=map.get(token);
					if(freq==null) {
						map.put(token,1);
					}else {
						map.put(token,freq+1);
					}
				}
			}
			br.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("Frequency of each wor in file: ");
		Set<Entry<String,Integer>> entrySet=map.entrySet();
		
		for(Entry<String,Integer> entry:entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
