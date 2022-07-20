package practice;

import java.util.Scanner;

public class Problem02 {

	public static void main(String[] args) {

		/* 홀 짝 판단
		 * 
		 * 정수 하나를 입력받고, 입력받은 정수가 홀, 짝 판단
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		if (x%2==0) {
			System.out.println("짝");
		}else {
			System.out.println("홀");
		}
		
		
		
		
	}

}
