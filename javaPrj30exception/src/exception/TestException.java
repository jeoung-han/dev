package exception;

public class TestException {

	public void test01() {
		System.out.println("test01 called...");
		try {
			int x = 1/0;
		}catch (Exception e) {
			System.out.println("예외는 내가 처리 했으니 안심해 "+e);
		}
			
		System.out.println("test01 end...");
	}

	public void test02() {
		System.out.println("test02 called...");
		System.out.println("test02 end...");
	}

	public void test03() {
		System.out.println("test03 called...");
		System.out.println("test03 end...");
	}

}
