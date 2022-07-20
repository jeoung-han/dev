package main;

import Tools.Tool;
import controller.MsgCtr;
import user.User;

public class Main {

	public static void main(String[] args) {

		MsgCtr msg = new MsgCtr();
		Tool t = new Tool();

		String name;
		while (true) {
			try {
				name = msg.rogin();
				break;
			} catch (Exception e) {}
		}
		User user = new User(name);
		
		msg.rayout(user);
		while(true) {
			int action = 0;
			while(true) {
				try {
					action = msg.action();
					break;
				} catch (Exception e) {System.out.println("양식에 맞게 작성해 주시기 바랍니다.");}
			}
			
			if(action==1) {
				while(true) {
					try {
						t.writer(user, msg.input());
						msg.rayout(user);
						break;
					} catch (Exception e) {System.out.println("양식에 맞게 작성해 주시기 바랍니다.");}
				}
			}else if(action==2){
				//("   1. 날짜    2. 입금   3. 출금    4. 카테고리별");
				while(true) {
					try {
						switch(msg.action2()) {
						case 1:	msg.rayout(user, msg.checkDate()); break;
						case 2: msg.rayout(user, true); break;
						case 3: msg.rayout(user, false); break;
						case 4: 
							switch(msg.action3()) {
							//("    1. 교통비   2. 식비   3. 생활비   4. 문화생활 ");
							case 1:	msg.rayout(user, "교통비"); break;
							case 2: msg.rayout(user, "식비"); break;
							case 3: msg.rayout(user, "생활비"); break;
							case 4: msg.rayout(user, "문화생활"); break;
							}
						}
						break;
					}catch (Exception e) {System.out.println("양식에 맞게 작성해 주시기 바랍니다.");}
				}
			}else break;
			
		}//mainLoop
		
		
		
		// 아이디 체크
		// 해당아이디 폴더 들어가서 파일 불러옴 전체파일
		// 파일에서 정보 불러옴
		// 총 입금액, 총 출금액, 예산, 차액
		// 이번 주 지출액,
		// 카테고리별 지출액
		// 입력하기 날짜 입력->입출금 선택 -> 카테고리 선택 ->금액(텝) -> 메모 (엔터)

	}

}
