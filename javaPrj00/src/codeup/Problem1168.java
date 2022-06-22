package codeup;

import java.util.Scanner;

public class Problem1168 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int year = x/=10000;
		
		if(y==1||y==2) {
			year += 1900;
			System.out.println(2012-year+1);
		}else {
			year += 2000;
			System.out.println(2012-year+1);
		}
	}
}
