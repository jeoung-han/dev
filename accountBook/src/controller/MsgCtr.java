package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import exception.notUserException;
import user.User;

public class MsgCtr {
	
	// 0 ■ | 1 날짜 | 2 입금,출금 | 3 카테고리 | 4 금액 | 5 메모
	String[] cArr = {"생활비","교통비","식비","문화생활"};

	Scanner sc = new Scanner(System.in);
	UserCtr uc = new UserCtr();
	FileInputCtr fic = new FileInputCtr();
	
	public void rayout(User user) {
		System.out.println("-----------------------");
		System.out.println(" ▶ "+"가계부");
		System.out.println("-----------------------");
		List<String> list = fic.readAll(user.getMyfile());
		for(String s : list) {
			System.out.println(s);
		}
		System.out.println("-----------------------");
	}
	
	public void rayout(User user, String title) {
		int temp = category(title);
		System.out.println("-----------------------");
		System.out.println(" ▶ "+title);
		System.out.println("-----------------------");
		List<Map<Integer, String>> list = fic.readHistory(user.getMyfile());
		for(Map<Integer, String> m : list) {
			if(m.get(3).equals(title)) System.out.println(m.toString());
		}
		System.out.println("-----------------------");
	}

	public String rogin() throws Exception {
		System.out.println("로그인하세요");
		System.out.print("id : ");
		String name = sc.nextLine();
		try {
			uc.checkUser(name);
		} catch (notUserException e) {
			System.out.println("아이디가 존재하지 않습니다.");
			System.out.println("생성 하시겠습니까?");
			if (check() == 1) uc.createUser(name);
			else throw new Exception();
		}
		return name;
	}

	private int check() {
		System.out.println(" 1. yes   2. no");
		System.out.print("입력 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	private int category(String s) {
		int i = 0;
		for(;i<cArr.length;i++) {
			if(cArr[i].equals(s)) break;
		}
		return i;
	}

}
