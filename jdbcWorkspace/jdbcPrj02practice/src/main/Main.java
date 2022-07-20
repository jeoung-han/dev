package main;

import java.util.Scanner;

import member.MemberController;
import member.MemberDto;

public class Main {
	
	public static MemberDto user = null;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MemberController mc = new MemberController();
		
		System.out.println("===== MEMBER =====");
		
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 마이페이지");
		
		String input = sc.nextLine();
		
		switch(input) {
		case "1" : 
			mc.login();
			break;
		case "2" : 
			int temp = mc.join();
			if(temp > 0) System.out.println("회원가입 성공!");
			else System.out.println("회원가입 실패...");
			break;
		case "3" : 
			mc.edit(); 
			break;
		default : System.out.println("입력 잘해바");
		}
		
	}

}
