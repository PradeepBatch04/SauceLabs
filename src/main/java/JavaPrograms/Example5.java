package JavaPrograms;

import java.util.Scanner;

public class Example5 {

	public static void main(String[] args) {
		// Program for count number of upper case, lower case, digits and special characters
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sentence : ");
		String x = scanner.nextLine();
		scanner.close();
		//my MOTHER is 88 my mother &%!@#
		int clc=0;
		int cuc=0;
		int cdi =0;
		int csc=0;		
        
		for(int i=0;i<x.length();i++)
		{
			char y = x.charAt(i);
			if(y!=' ') {
				if(Character.isUpperCase(y)) {
					cuc++;
				}else if (Character.isLowerCase(y)) {
					clc++;
				}else if (Character.isDigit(y)) {
					cdi++;
				}else {
					csc++;
				}
			}
		}	
		System.out.printf(" Count of uppercase in string %d%n",cuc);
		System.out.printf(" Count of lowercase in string %d%n",clc);
		System.out.printf(" Count of digits in string %d%n",cdi);
		System.out.printf(" Count of special characters in string %d",csc);
		

	}

}
