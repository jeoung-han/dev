package codeup;

import java.util.Scanner;

public class Problem1159 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		System.out.println(((i>=50&&i<=70)||(i%6==0)) ? "win" : "lose");
		
	}

}
