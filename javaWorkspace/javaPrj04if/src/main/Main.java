package main;

public class Main {

	public static void main(String[] args) {
		
		/*
		제어문 > 조건문
		if(조건문[참,거짓 반환]) {
			조건문1이 참일 때 실행문
		}[else if (조건문2){
			조건문 1 거짓, 조건문 2 참일 때
		}else {
			모두 거짓일 때 실행문
		}]생략가능
		
		
		*/
		System.out.println("==========제어문 테스트==========");
		
		int x = 10;
		
		if (x > 0) {
			System.out.println("x 는 양수입니다.");		
		}else if (x == 0) {
			System.out.println("x 는 0입니다.");
		}
		else {
			System.out.println("x 는 음수입니다.");
		}
		
		
		
		
	}

}
