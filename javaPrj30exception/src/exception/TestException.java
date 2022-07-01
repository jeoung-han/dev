package exception;

public class TestException {

	public void test01() throws Exception {
		System.out.println("test01 called...");
		test02();
		System.out.println("test01 end...");
	}

	public void test02() throws Exception {
		System.out.println("test02 called...");
		test03();
		System.out.println("test02 end...");
	}

	public void test03() throws Exception{
		System.out.println("test03 called...");
		throw new PokemonException("히히");
//		System.out.println("test03 end...");
	}

}
