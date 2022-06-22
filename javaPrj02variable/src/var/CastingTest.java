package var;

public class CastingTest {

	public static void main(String[] args) {
		
		/*
		형변환
		묵시적형변환 : 서로 다른 타입은 연산이 불가하지만, 컴퓨터가 알아서 변환
			
		명시적형변환 : 강제로 타입을 변환시킴 대상 앞에 (타입) 명시 *데이터 손실이 일어남
		*/
		
		int a = 10;
		int b = 20;

		
		int c = a+b;
		System.out.println(c);
	}

}
