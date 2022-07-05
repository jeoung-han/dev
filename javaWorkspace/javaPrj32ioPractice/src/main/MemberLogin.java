package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MemberLogin {

	public void login() {
		// 안내문
		System.out.print("아이디 : ");
		String id = Main.sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = Main.sc.nextLine();

		boolean isLogin = processLogin(id, pwd);

		if (isLogin) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}

	private boolean processLogin(String id, String pwd) {

		File f = new File("D:\\dev\\javaPrj32ioPractice\\member.txt");
		boolean result = false;
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String data;
			while((data = br.readLine())!=null) {
				if(data.length()<2)continue;
				String[] account = data.split(" ");
				String idData = account[0];
				String pwdData = account[1];
				result = id.equals(idData) && pwd.equals(pwdData);
				if(result)break;
			}
		} catch (IOException e) {
			
		}

		return result;

	}

}
