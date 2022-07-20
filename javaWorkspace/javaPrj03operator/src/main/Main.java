package main;

public class Main {

	public static void main(String[] args) {

		/*
		 * 연산자
		 * 
		 * 
		 * 산술연산자 : 숫자 랑 숫자 => 숫자
		 * +, -, *, /(나눗셈의 몫), %(나눗셈의 나머지), = (대입연산자 * 같다의 등호가 아님)
		 *  
		 * 비교연산자 : 숫자 랑 숫자 => 논리 (참, 거짓)
		 * <, >, <=, >=, ==, != (부등호)
		 * 
		 * 논리연산자 : 논리 랑 논리 => 논리
		 * and, or, not
		 *  &&, ||, !
		 *  
		 * T && T ==> T
		 * T && F ==> F
		 * F && T ==> F
		 * F && F ==> F
		 * 
		 * T || F ==> T
		 * T || T ==> T
		 * F || T ==> T
		 * F || F ==> F
		 * 
		 * !F ==> T
		 * !T ==> F
		 *  
		 */
		
		System.out.println(10 + 20);
		
		System.out.println(10 < 20);
		
		System.out.println(true && false);

	}

}
