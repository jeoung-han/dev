package codeup;

import java.util.Scanner;

public class Problem1157 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double i = sc.nextDouble();
		
		if (i<=60 && i>=50) {
			System.out.println("win");
		}else {
			System.out.println("lose");
		}
		
	}

}
