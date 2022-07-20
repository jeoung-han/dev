package kiosk;

import java.util.Scanner;

import menu.Menu;
import menu.dough.*;
import menu.drink.*;
import menu.side.*;
import menu.topping.*;
import order.Order;

public class Kiosk2 {

	private Scanner sc = new Scanner(System.in);
	
	Menu[] doughs = {new menu.dough.Cheese(), new Normal(), new Bite(), new RichGold(), new Gold() };
	Menu[] toppings = {new menu.topping.Cheese(), new menu.topping.Potato(), new Shirimp() };
	Menu[] sides = {new menu.side.Potato(), new Spaghetti(), new Wing(), null };
	Menu[] drinks = {new Coke(), new Sprite(), new Fanta(), null };
	
	public Order useKiosk() {
		boolean isTakeOut = checkTakeOut();
		Menu dough = selectMenu("도우",doughs);
		Menu topping = selectMenu("토핑",toppings);
		Menu side = selectMenu("사이드",sides);
		Menu drink = selectMenu("음료",drinks);
		Menu[] order = {dough,topping,side,drink};
		int price = calcPrice(order);
		int time = calcTime(order);
		return new Order(isTakeOut, 0, 0, 0, 0, price, time);
	}
	
	private int calcPrice(Menu[] order) {
		int total = 0;
		for(Menu m : order) {
			if(m!=null) {
				total += m.getPrice();
			}
		}
		return total;
	}
	
	private int calcTime(Menu[] order) {
		int total = 0;
		for(Menu m : order) {
			if(m!=null) {
				total += m.getTime();
			}
		}
		return total;
	}
	
	private Menu selectMenu(String name, Menu[] menuArr) {
		System.out.println("=========="+name+"==========");
		for(int i = 0; i<menuArr.length;i++) {
			if(menuArr[i]==null) {
				System.out.println((i+1)+". 없음");
			}else {
				System.out.println((i+1)+". "+menuArr[i]);
			}
		}
		int n = Integer.parseInt(sc.nextLine());
	return menuArr[n-1];
	}

	// 키오스크 사용하게 하기
	// 1. 선택하는 화면 (포장여부 선택)
	private boolean checkTakeOut() {
		System.out.println("포장하시겠습니까? (Y/N)");
		String result = sc.nextLine();
		if (result.equalsIgnoreCase("Y")) {
			return true;
		} else {
			return false;
		}
	}
		

	// 도우선택 (일반 치즈 골드 바이트 리치골드)

//	private int selectDough() {
//		// 선택지 보여주기
//		System.out.println("========== 도우 ==========");
//		System.out.println("1. ");
//		System.out.println("2. ");
//		System.out.println("3. ");
//		System.out.println("4. ");
//		System.out.println("5. ");
//		//
//		return Integer.parseInt(sc.nextLine());
//	}
//
//	// 토핑 선택 (콤비. 페페, 치즈, 포테이토, 불고기, 쉬림프, 고구마)
//	private int selectTopping() {
//		System.out.println("========== 토핑 ==========");
//		System.out.println("1. 콤비네이션");
//		System.out.println("2. 페페로니");
//		System.out.println("3. 치즈");
//		System.out.println("4. 포테이토");
//		System.out.println("5. 불고기");
//		System.out.println("6. 고구마");
//		System.out.println("7. 쉬림프");
//		//
//		return Integer.parseInt(sc.nextLine());
//	}
//
//	// 사이드 선택 (스파게티, 감자튀김, 윙)
//	private int selectSide() {
//		System.out.println("========== 사이드 ==========");
//		System.out.println("1. 스파게티");
//		System.out.println("2. 감자튀김");
//		System.out.println("3. 윙");
//		System.out.println("4. 없음");
//		//
//		return Integer.parseInt(sc.nextLine());
//	}
//
//	// 음료(콜라, 사이다)
//	private int selectDrink() {
//		System.out.println("========== 음료 ==========");
//		System.out.println("1. 콜라");
//		System.out.println("2. 사이다");
//		System.out.println("3. 환타");
//		System.out.println("4. 없음");
//		//
//		return Integer.parseInt(sc.nextLine());
//	}

}
