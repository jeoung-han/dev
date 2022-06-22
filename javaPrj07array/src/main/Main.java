package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== 배열 =====");
		
		//학생 10명의 성적 입력받는 프로그램
		
		Scanner sc = new Scanner(System.in);
		int[] score = new int[10];
		
		for(int i=0;i<score.length;i++) {
			score[i] = sc.nextInt();
		}
		
		System.out.println(Arrays.toString(score));
		
		/*
		 * 배열
		 * - 데이터 타입이 같은 여러개의 변수를 한번에 만들 수 있음
		 * - 인덱스(index)는 0에서 부터 시작
		 * - 마지막 인덱스는 arr.length - 1
		 */
//			int[] a; //배열 변수 선언
//			a = new int[3]; //배열 생성하여, a에 할당			
	
		int[] a = {1,2,3};
		System.out.println("배열의 길이 :::"+a.length);
	}

}
