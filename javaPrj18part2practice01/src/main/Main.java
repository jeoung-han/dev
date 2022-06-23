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
//		kiosk.useKiosk();
		Order order = kiosk.useKiosk();
				
		kiosk.calc(order);
		
		// 소요시간 계산
		System.out.print("소요시간 : ");
		System.out.println(order.getTime());

		// 가격 계산 출력
		System.out.print("가격 : ");
		System.out.println(order.getPrice());

		// 계산하기(현금) 거스름돈 끝

	}

}
