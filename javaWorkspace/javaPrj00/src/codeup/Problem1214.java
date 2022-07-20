package codeup;

import java.util.Scanner;

public class Problem1214 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);

		int year = sc.nextInt();
		int month = sc.nextInt();
		
//		if(month==2) {
//			if(year%400==0||(year%4==0&&year%100!=0)) {
//				System.out.println(29);
//			}else {
//				System.out.println(28);
//			}
//		}else if(month<8){
//			if(month%2==0) {
//				System.out.println(30);
//			}else {
//				System.out.println(31);
//			}
//		}else {
//			if(month%2==0) {
//				System.out.println(31);
//			}else {
//				System.out.println(30);
//			}
//		}
		
		//윤년판단
		int temp =28;
		if(year%400==0||(year%4==0&&year%100!=0)) {
			temp = 29;
		}
		//
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: System.out.println(31);break;
		case 4:
		case 6:
		case 9:
		case 11:System.out.println(30);break;
		default:System.out.println(temp);
		}
		
		

	}
}

