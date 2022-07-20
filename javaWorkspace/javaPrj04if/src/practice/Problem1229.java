package practice;

import java.util.Scanner;

public class Problem1229 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double height = sc.nextDouble();
		double weight = sc.nextDouble();
		
		double stdWeight;
				
		if (height<150) {
			stdWeight = height-100;
		}else if (height<160) {
			stdWeight = (height-150)/2 + 50;
		}else {
			stdWeight = (height-100)*0.9;
		}
		
		double ob = (weight-stdWeight)*100/stdWeight;
		
		if (ob<=10) {
			System.out.println("정상");
		}else if (10<ob&&ob<=20) {
			System.out.println("과체중");
		}else {
			System.out.println("비만");
		}
		
	}

}
