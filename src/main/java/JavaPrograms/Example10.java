package JavaPrograms;

public class Example10 {

	public static void main(String[] args) {
		// Reverse given string using string buffer class
		
		String x= "abdul kalam";
		
		StringBuffer sb = new StringBuffer(x);
		StringBuffer y =sb.reverse();
		System.out.println(y);
		
		
		String a = "hello pradeep how are you";
		a=a.trim();
        String [] words=a.split(" ");
      
		for(int i=0;i<words.length;i++) {
			StringBuffer sbb = new StringBuffer(words[i]);
			
			String b=words[i].charAt(words[i].length()-1)+sbb.substring(1, words[i].length()-1)+words[i].charAt(0);
			System.out.println(b);
		}
		
		
		
		
	    
	}

}
