
public class Plaindrome {

	public static void main(String[] args) {
		
		int [] input = {223,323,454,666};
		
		for(int i=0;i<input.length;i++) {
			
			int value = input[i];
			
			int temp = value;
			int y =0;
			while(temp!=0) {
				
				int reminder = temp%10;
				y=y*10+reminder;
				temp=temp/10;
			}
	
			if(y==value) {
				System.out.println(value + " is Palindrome");
			}else {
				System.out.println(value + " is not Palindrome");
			}
			
		}

	}

}
