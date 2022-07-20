package controller;

import java.text.DecimalFormat;
import java.util.Scanner;
import Tools.Tool;
import exception.NotTypeException;
import exception.NotUserException;
import user.User;

public class MsgCtr {

	// 0 ■ | 1 날짜 | 2 입금,출금 | 3 카테고리 | 4 금액 | 5 메모
//	String[] cArr = {"생활비","교통비","식비","문화생활"};

	Scanner sc = new Scanner(System.in);
	UserCtr uc = new UserCtr();
	FileOutputCtr foc = new FileOutputCtr();
	DecimalFormat df = new DecimalFormat("###,###");
	Tool t = new Tool();
	
	public int checkDate() throws NotTypeException {
		System.out.println("---------------------------------------------------");
		System.out.print("날짜를 입력해주시기 바랍니다. yyyymmdd");
		String temp = sc.nextLine();
		if (temp.length()!=8)
			throw new NotTypeException();
		return Integer.parseInt(temp);// exception
	}

	public int action() throws Exception {
		System.out.println("---------------------------------------------------");
		System.out.println("   1. 작성하기   2. 필터보기   3. 종료하기");
		System.out.println("---------------------------------------------------");
		int i = Integer.parseInt(sc.nextLine());
		if (i == 1 || i == 2 || i == 3) {
			return i;
		} else throw new NotTypeException();
	}

	public int action2() throws Exception {
		System.out.println("---------------------------------------------------");
		System.out.println("   1. 날짜    2. 입금   3. 출금    4. 카테고리별");
		System.out.println("---------------------------------------------------");
		int i = Integer.parseInt(sc.nextLine());
		if (i == 1 || i == 2 || i == 3 || i == 4) {
			return i;
		} else throw new NotTypeException();
	}

	public int action3() throws Exception {
		System.out.println("---------------------------------------------------");
		System.out.println("    1. 교통비   2. 식비   3. 생활비   4. 문화생활 ");
		System.out.println("---------------------------------------------------");
		int i = Integer.parseInt(sc.nextLine());
		if (i == 1 || i == 2 || i == 3 || i == 4) {
			return i;
		} else throw new NotTypeException();
	}

	public String input() throws Exception {
		String s = "■";
		System.out.println("---------------------------------------------------");
		System.out.print("   작성 일시 (yyyymmdd): ");
		String temp = sc.nextLine();
		if (temp.length()!=8)
			throw new NotTypeException();
		Integer.parseInt(temp);// exception
		s += "\t" + temp;
		System.out.println("---------------------------------------------------");
		System.out.println("   1. 입금    2. 출금 ");
		System.out.println("---------------------------------------------------");
		temp = sc.nextLine();
		if (temp.equals("1")) {
			s += "\t입금 ▲";
		} else if (temp.equals("2")) {
			s += "\t출금 ▼";
		} else throw new NotTypeException();
		System.out.println("---------------------------------------------------");
		System.out.println("    1. 교통비   2. 식비   3. 생활비   4. 문화생활 ");
		System.out.println("---------------------------------------------------");
		temp = sc.nextLine();
		if (temp.equals("1")) {
			s += "\t교통비";
		} else if (temp.equals("2")) {
			s += "\t식비";
		} else if (temp.equals("3")) {
			s += "\t생활비";
		} else if (temp.equals("4")) {
			s += "\t문화생활";
		} else throw new NotTypeException();
		System.out.println("---------------------------------------------------");
		System.out.print("   금액 : ");
		temp = sc.nextLine();
		temp.replaceAll(",", "");
		s += "\t" + df.format(Integer.parseInt(temp));
		System.out.println("---------------------------------------------------");
		System.out.print("   메모 :  ");
		s += "\t" + sc.nextLine();
		return s;
	}

	public void rayout(User user) {
		System.out.println("---------------------------------------------------");
		System.out.println(" ▶ " + "가계부");
		System.out.println("---------------------------------------------------");
		t.printList(user);
		System.out.println("---------------------------------------------------");
	}

	public void rayout(User user, String title) {
		System.out.println("---------------------------------------------------");
		System.out.println(" ▶ " + title);
		System.out.println("---------------------------------------------------");
		t.printHistory(user, title);
		System.out.println("---------------------------------------------------");
	}

	public void rayout(User user, int date) {
		System.out.println("---------------------------------------------------");
		System.out.println(" ▶ " + date);
		System.out.println("---------------------------------------------------");
		t.printHistory(user, date);
		System.out.println("---------------------------------------------------");
	}

	public void rayout(User user, boolean deposit) {
		String temp = "출금 ▼";
		if (deposit) {
			temp = "입금 ▲";
		}
		System.out.println("---------------------------------------------------");
		System.out.println(" ▶ " + temp);
		System.out.println("---------------------------------------------------");
		t.printHistory(user, deposit);
		System.out.println("---------------------------------------------------");
	}

	public String rogin() throws Exception {
		System.out.println("로그인하세요");
		System.out.print("id : ");
		String name = sc.nextLine();
		try {
			uc.checkUser(name);
		} catch (NotUserException e) {
			System.out.println("아이디가 존재하지 않습니다.");
			System.out.println("생성 하시겠습니까?");
			if (check() == 1)
				uc.createUser(name);
			else throw new Exception();
		}
		return name;
	}

	private int check() {
		System.out.println(" 1. yes   2. no");
		System.out.print("입력 : ");
		return Integer.parseInt(sc.nextLine());
	}

}
