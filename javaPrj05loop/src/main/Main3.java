package main;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {

		
		System.out.println("===== 반복문 =====");
		//for
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i=0;i<num;i++) {
			if(i%2==0) {
				continue;
			}
			System.out.println(i+"번째 : hello world");
		}
			
	
	}

}
