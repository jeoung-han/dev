package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		GameController gc = new GameController();
		gc.printInfo();
		
		GameManager gm = new GameManager();
		int random = gm.getRandom();
		
		//시도한 횟수 체크
		int cnt = 0;
		
		while(true) {
			//사용자로부터 숫자 입력받기
			int user = gc.scanUserNum();
			cnt++;
			//입력받은 결과 판단, 출력
			boolean isFinish = gc.judge(user, random, cnt);
			if(isFinish) {
				break;
			}
		
		
		}
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
	}
}
