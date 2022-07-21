package main;

import java.util.Scanner;

import member.MemberController;
import member.MemberDto;

public class Main {
	
	public static MemberDto user = null;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MemberController mc = new MemberController();
		
		boolean isFinish = false;
		while(!isFinish) {
			System.out.println("===== MEMBER =====");
			
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 마이페이지");
			System.out.println("9. 프로그램 종료");
			
			String input = sc.nextLine();
			
			switch(input) {
			case "1" : 
				MemberDto dto = mc.login();
				if(dto != null) {
					System.out.println("로그인 성공");
					Main.user = dto;
				}else System.out.println("로그인 실패");
				break;
			case "2" : 
				int temp = mc.join();
				if(temp > 0) System.out.println("회원가입 성공!");
				else System.out.println("회원가입 실패...");
				break;
			case "3" : 
				mc.edit(); 
				break;
			case "9" : isFinish = true; break;
			default : System.out.println("입력 잘해바");
			}
		}
		
		
		
	}
	

}
