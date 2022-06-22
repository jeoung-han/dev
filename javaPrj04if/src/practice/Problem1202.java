package practice;

import java.util.Scanner;

public class Problem1202 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
//		if (score>=90) {
//			System.out.println("A");
//		}else if (score>=80) {
//			System.out.println("B");
//		}else if (score>=70) {
//			System.out.println("C");
//		}else if (score>=60) {
//			System.out.println("D");
//		}else {
//			System.out.println("F");
//		}
		
		char sco = (score>=90) ? 'A' : (score>=80) ? 'B' : 
			(score>=70) ? 'C' : (score>=60) ? 'D' : 'F';
		
		System.out.println(sco);


	}

}
