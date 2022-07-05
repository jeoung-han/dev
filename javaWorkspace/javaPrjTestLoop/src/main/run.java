package main;

import java.util.Scanner;

public class run {

	public static void main(String[] args) {
		
		System.out.println("===== 가위바위보 게임 =====");
		
		int r;
		r = (int) (Math.random()*3+1);

		Scanner sc = new Scanner(System.in);
		System.out.print("가위,바위,보 중 하나를 선택하시오 : ");
		String user = sc.nextLine();
		String com = (r==1) ? "가위" : (r==2) ? "바위" : "보";
		
		
		System.out.println("user : "+user);
		System.out.println("com : "+com);
		System.out.println(judgment(com, user));
		
//		if(com.equals("가위")) 
//		{
//			if(user.equals("가위")) 
//			{
//				System.out.println("비김");
//			}else if(user.equals("바위")) {
//				System.out.println("승리!");
//			}else if(user.equals("보")){
//				System.out.println("패배");
//			}
//		}
//		else if(com.equals("바위")) 
//		{
//			if(user.equals("가위")) 
//			{
//				System.out.println("패배");
//			}else if(user.equals("바위")) {
//				System.out.println("비김");
//			}else if(user.equals("보")){
//				System.out.println("승리!");
//			}
//		}
//		else if(com.equals("보")) 
//		{
//			if(user.equals("가위")) 
//			{
//				System.out.println("승리!");
//			}else if(user.equals("바위")) {
//				System.out.println("패배");
//			}else if(user.equals("보")){
//				System.out.println("비김");
//			}
//		}

		
		
	}//main
	public static String judgment(String com, String user){
		String result = "";
		if(com.equals(user)){
			result = "비김";
		}else if(user.equals("가위")&&com.equals("보")||user.equals("바위")&&com.equals("가위")||user.equals("보")&&com.equals("바위")) {
			result = "승리";
		}else if(user.equals("바위")&&com.equals("보")||user.equals("보")&&com.equals("가위")||user.equals("가위")&&com.equals("바위")) {
			result = "패배";
		}
		return result;
	}
}
