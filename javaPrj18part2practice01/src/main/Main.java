package main;

import employee.Emp;
import kiosk.Kiosk;
import order.Order;

public class Main {
	
	public static Emp emp = new Emp("아이유");

	public static void main(String[] args) {

		System.out.println("KH피자가게");

		// 직원이 인사
		emp.sayWelcome();
		
		
		Kiosk kiosk = new Kiosk();
		Order order = kiosk.useKiosk();
		
		System.out.println(order);
		// 소요시간 계산

		// 가격 계산 출력

		// 계산하기(현금) 거스름돈 끝

	}

}
