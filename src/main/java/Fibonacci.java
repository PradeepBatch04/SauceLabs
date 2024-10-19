
public class Fibonacci {

	public static void main(String[] args) {
		int num =50;
		
		int x=0,y=1;
		
		System.out.printf(x+" "+y);
       do {
    	   int z = x+y;
    	   System.out.printf(" %d",z);
    	   x=y;
    	   y=z;
    	   
       }while(x+y<=num);
	}

}
