package JavaPrograms;

import java.util.HashMap;
import java.util.Scanner;



public class Example6 {

	public static void main(String[] args) {
		// Program to find the duplicate words and their number of occurrences in a string
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sentence : ");
		String x = scanner.nextLine();
		scanner.close();
		x=x.trim();
		x=x.toLowerCase();
		String [] words=x.split(" ");
		System.out.println(words.length);
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i=0;i<words.length;i++) {
			
			if(hm.containsKey(words[i])) {
				hm.put(words[i], hm.get(words[i])+1);
			}else {
				hm.put(words[i], 1);
			}
			
		}
		System.out.println(hm);
		System.out.println("Count of distint words size : "+hm.keySet().size());
		//Display count of duplicate words and there occurrences.
		int count=0;
		for(String word:hm.keySet()) {
			if(hm.get(word)>1) {
			   System.out.println(word +" occurred "+hm.get(word));	
			   count++;
			}
		}
		System.out.println("count of duplicate words in string "+count);
	
	}
  
}
