package JavaPrograms;

public class PrimeNumber {

	public static void main(String[] args) {
		
		checkPrimeNumber(11);

	}
	
	static public void  checkPrimeNumber(int n) {
		
		int flag=0;
		if(n!=0||n!=1) {
			
			for(int i=2;i<n;i++) {
				if(n%i==0) {
					flag=1;
					System.out.println(n +" not Prime number");
					break;
				}
			}
		}
		if(flag==0) {
			System.out.println(n +" Prime number");
		}
		
		
	}

}
