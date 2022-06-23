package practice;

import java.util.Scanner;

public class Problem1151 {

	public static void main(String[] args) {

		// 10보다 작은수를 입력받으면 small 아니면 출력 X
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		if (x<10) {
			System.out.println("small");
		}

	}

}
