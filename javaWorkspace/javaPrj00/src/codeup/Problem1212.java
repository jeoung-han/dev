package codeup;

import java.util.Scanner;

public class Problem1212 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a<=c&&b<=c) {
			if(c<a+b) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}else if(a<=b&&c<=b) {
			if(b<a+c) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}else if(b<=a&&c<=a) {
			if(a<c+b) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		

	}
}

