package main;

public class Main2 {
	public static void main (String[] args) {
		
		System.out.println("=====switch 문=====");
		
		//switch
		//부합하는 항목으로가서 그 아래까지 전부 실행
		int x = 10;
		switch(x/*기준값*/) {
		case 10/*비교값*/ : System.out.println("x는 10 입니다.");/*실행내용*/break;
		case 20: System.out.println("x는 20입니다.");break;
		case 30: System.out.println("x는 30입니다.");break;
		}
		
		
	}

}
