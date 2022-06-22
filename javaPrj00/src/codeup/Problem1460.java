package codeup;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1460 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int num = 1;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(num+" ");
				num++;
			}
			System.out.println();
		}
		
		for(int i = 0; i<n; i++) {
			System.out.print(num+" ");
			num++;
		}
		
		
	}

}
