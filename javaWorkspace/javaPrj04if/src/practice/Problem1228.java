package practice;

import java.util.Scanner;

public class Problem1228 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double height = sc.nextDouble();
		double weight = sc.nextDouble();
		
		double standWeight = (height - 100)*0.9;
		System.out.println("standWeight : "+standWeight);
		double bmi = (weight - standWeight)*100/standWeight;
		System.out.println("obesity : "+bmi);
		
		if (bmi<=10) {
			System.out.println("정상");
		}else if (bmi<=20) {
			System.out.println("과체중");
		}else {
			System.out.println("비만");
		}

	}

}
