package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("1 ~ 50 사이의 숫자를 입력하세요 : ");
		int input;
		int answer = 33;
		
		
		while(true) {
			input = sc.nextInt();
			if(input == answer) {
				System.out.println("정답입니다.");
				break;
			}else {
				if(input > answer) {
					System.out.println("DOWN");
				}else {
					System.out.println("UP");
				}
			}
		}
	}

}
