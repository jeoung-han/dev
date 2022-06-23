package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("====== 반복문 ======");
		
//		문자열과 변수의 혼용
//		int x = 10;
		
//		System.out.print("x의 값 : ");
//		System.out.println(x);
		
//		System.out.println("x의 값 : "+x);
		
		/*
		 * 반복문
		 * 
		 * while(조건식){실행내용}
		 * 
		 * do{실행내용} while(조건식);
		 * 
		 * for(초기식;조건식;증감식){실행내용}
		 * 
		 * break : 반복문 탈출
		 * continue : 반복문 처음으로 돌아감
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			//숫자 입력받기
			int input = sc.nextInt();
			//숫자 출력하기
			System.out.println("입력하신 숫자 : "+input);
			//만약, 음수가 입력되면 반복문 종료
			if(input<0) {
				break;
			}
			
			
			
			
			
		}
		

	}

}
