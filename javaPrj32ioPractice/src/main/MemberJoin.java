package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemberJoin {
	
	public void join() {
		
		System.out.print("아이디 : ");
		String id = Main.sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pwd = Main.sc.nextLine();
		
		boolean isValid = checkValidation(id, pwd);
		if(!isValid) System.out.println("실패");
		else {
			saveData(id,pwd);
			
			System.out.println("회원가입 성공");
		}
		
	}

	private boolean checkValidation(String id, String pwd) {
		//아이디 검사 
		if(id.length()<2) return false;
		if(!checkDup(id)) return false;
		//비밀번호 검사 
		if(pwd.length()<4) return false;
		return true;
	}

	private boolean checkDup(String id) {
		File f = new File("D:\\dev\\javaPrj32ioPractice\\member.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String data;
			while((data = br.readLine())!=null) {
				if(id.equals(data.split(" ")[0])) {
					System.out.println("아이디 중복");
					return false;
				}
			}
		} catch (IOException e) {
			
		}
		return true;
	}

	private void saveData(String id, String pwd) {
		
		File f = new File("D:\\dev\\javaPrj32ioPractice\\member.txt");
				
		try (FileWriter fw = new FileWriter(f,true);
			 BufferedWriter bw = new BufferedWriter(fw);) {
			bw.write(id);
			bw.write(" ");
			bw.write(pwd);
			bw.write("\n");
			bw.flush();
		} catch (Exception e) {}
		
	}
	
}
