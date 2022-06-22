package codeup;
import java.util.Scanner;

public class Problem1169 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		int year = 2012-x+1;
		
		if(year>1999) {
			System.out.println(year%100+" 3");
		}else {
			System.out.println(year%100+" 1");
		}
	}
}
