package practice;

import java.util.Scanner;

public class Problem1166 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		
		if (year%400==0) {
			System.out.println("윤년");
		}else if (year%4==0 && year%100!=0) {
			System.out.println("윤년");
		}else {
			System.out.println("윤년이 아니다");
		}
		
		
	}

}
