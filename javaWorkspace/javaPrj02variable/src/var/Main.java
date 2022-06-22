package var;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * 변수
		 * 
		 * 변수 ?  변하는 수
		 * 
		 * [문법]
		 * 변수타입 변수명 = 값;
		 *  
		 * [타입]
		 * boolean : 논리 (true / false) 참과 거짓 1 / 0 문자의 유 / 무
		 * 
		 * char : 문자
		 * String : 문자열
		 * 
		 * (1byte) byte : 정수 - 표현범위가 -128 ~ +127 (256)
		 * (2byte) short : 정수 - 표현범위 -3만 ~ 3만 (65536)
		 * (4byte) int : 정수 -21억 ~ +21억 (42억)
		 * (8byte) long : 정수 
		 * 
		 * (4byte) float : 실수
		 * (8byte) double : 실수
		 * 
		 * 데이터 오버플로우 : 한바퀴 돌았다
		 * 
		 * 
		 * */
		
		//문자
		char abc = 's';
		System.out.println(abc);
		
		//문자열
		String sss = "이것은 문자열 입니다.";
		System.out.println(sss);
		
		//논리값
		boolean b = true;
		System.out.println(b);

		//정수
		byte by = 1;
		short s = 2;
		int age = 20;
		long l = 13425881651299124l;
		
		//실수
		double height = 183.7;
		float weight = 88.85f;
		
		
	}

}
