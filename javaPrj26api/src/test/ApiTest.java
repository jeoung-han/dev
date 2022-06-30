package test;

public class ApiTest {
	
	public void test01() {
		String str = "Hello World";
		
		//charAt
//		char result = str.charAt(1);
		
		//compareTo
//		int result = str.compareTo("abc");
		
	}
	
	public void test02() {
		//StringBuilder, StringBuffer
		
//		StringBuilder sb = new StringBuilder();
//		sb.append("zz");
//		sb.append("abc");
//		System.out.println(sb);
		
		StringBuffer sb = new StringBuffer();
		sb.append("zz");
		System.out.println(sb);
		
	}
	
	public void test03() {
		//math
		
		int result = Math.abs(-77);
		
		System.out.println(result);

		
	}
	
	public void test04() {
		String s = "apple,samsug,lg,google";
		String[] arr = s.split(",");
	}

}
