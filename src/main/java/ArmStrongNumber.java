import java.util.Scanner;

public class ArmStrongNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();sc.close();
		
		//Get count digits
		int temp=num;
		int count =0;
		
		while(temp!=0) {
			temp=temp/10;
			count++;
		}
		System.out.printf("%d digits in given number %d", count,num);
		System.out.println();
		
		int temp1=num;
		int value=0;
		while(temp1!=0) {
			int reminder = temp1%10;
			value = (int) (value+Math.pow(reminder, count));
			temp1=temp1/10;
		}
		if(value==num) {
			
			System.out.printf("%d is the armstrong number",num);
		}else {
			System.out.printf("%d is not armstrong number",num);
		}

	}

}
