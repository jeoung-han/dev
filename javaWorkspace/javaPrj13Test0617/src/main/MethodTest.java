package main;

public class MethodTest {
	
	//메소드 오버로딩 (파라미터만 다르게, 같은 이름으로 여러개 만드는거)

	public void test() {
		System.out.println("test() called...");
	}
	
	public void test(int x, int y) {
		System.out.println("test() called...");
	}
	
//	public void test(int x, String s) {
//		System.out.println("test() called...");
//	}
//	
//	public boolean test(int x, String s) {
//		System.out.println("test() called...");
//		return true;
//	}
	
}
