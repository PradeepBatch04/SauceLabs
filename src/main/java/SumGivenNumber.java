import java.util.Scanner;

public class SumGivenNumber {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);
		 
		 int num = scanner.nextInt();
		 scanner.close();
		 
		 int temp= num;
		 int sum=0;
		 while(temp!=0) {
			 int reminder = temp%10;
			 
			 sum=sum+reminder;
			 temp=temp/10;
		 }
		 System.out.printf("%d is sum of digits in %d",sum,num);

	}

}
