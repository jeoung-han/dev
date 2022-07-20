package codeup;

import java.util.Scanner;

public class Problem1158 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		System.out.println(((i>=30&&i<=40)||(i<=70&&i>=60)) ? "win" : "lose");
		
	}

}
