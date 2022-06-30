package main;

import java.io.IOException;

import controller.MsgCtr;
import controller.UserCtr;
import exception.notUserException;
import user.User;

public class Main {

	public static void main(String[] args) {

		MsgCtr msg = new MsgCtr();

		String name;
		while (true) {
			try {
				name = msg.rogin();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		User user = new User(name);
		
		
		
		// 아이디 체크
		// 해당아이디 폴더 들어가서 파일 불러옴 전체파일
		// 파일에서 정보 불러옴
		// 총 입금액, 총 출금액, 예산, 차액
		// 이번 주 지출액,
		// 카테고리별 지출액
		// 입력하기 날짜 입력->입출금 선택 -> 카테고리 선택 ->금액(텝) -> 메모 (엔터)

	}

}
