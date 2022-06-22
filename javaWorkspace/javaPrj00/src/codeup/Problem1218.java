package codeup;

import java.util.Scanner;

public class Problem1218 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(c<a+b){
			if(a==b&&b==c) {
				System.out.println("정삼각형");
			}else if(a==b||b==c) {
				System.out.println("이등변삼각형");
			}else if(a*a+b*b==c*c){
				System.out.println("직각삼각형");
			}else {
				System.out.println("삼각형");
			}
			
		}else {
			System.out.println("삼각형아님");
		}
			
	}
}

