package JavaPrograms;

public class ReserveWord {

	public static void main(String[] args) {
		// Reserve words in string
		
		String x = "Tell me about Narachandhrababu naidu";
		String rever="";
		String append="";
		
		String [] words=x.split(" ");
		for(String word: words) {
			
			char [] cha = word.toCharArray();
			for(int i=cha.length-1;i>=0;i--) {
			   rever=rever+cha[i];	
			}	
			append =append+" "+rever;
			rever="";
		}
		
		 System.out.println(append);
	}


}
