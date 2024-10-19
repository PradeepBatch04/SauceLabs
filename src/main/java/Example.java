import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ForkJoinPool;

public class Example {

	public static void main(String[] args) {
		String input= "aaaaeeejjjddbbee";
		
		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<Character, Integer>();

		for(int i=0;i<input.length();i++){
				 if(input.charAt(i)!=0) {
					 if(hm.containsKey(input.charAt(i))){

						  hm.put(input.charAt(i),hm.get(input.charAt(i))+1);

					      }else{
						hm.put(input.charAt(i),1);
					     }
					 
				 }      
					} 
		//put (key,value)
		for(Character c:hm.keySet()){

			System.out.print(c +""+ hm.get(c));
			}
	}
		

	

}
