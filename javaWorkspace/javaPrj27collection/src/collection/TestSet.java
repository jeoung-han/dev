package collection;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

	public void testMethod() {
		// Set > HashSet
		Set<String> hs = new HashSet<String>();

		/*
		 * 순서 없음 중복 불가
		 * 
		 */

		// 값 넣기
		hs.add("one");
		hs.add("two");
		hs.add("three");
		hs.add("four");
		hs.add("five");
		hs.add("six");
		hs.add("one");
		hs.add("one");
		hs.add("one");

		// 사이즈 확인
		System.out.println(hs.size());

		// 포함 여부 확인
		System.out.println(hs.contains("one"));

		// 비어 있는지 확인
		System.out.println(hs.isEmpty());

		// 지우기
		hs.remove("three");
		System.out.println("--------------------------------");

		Object[] result = hs.toArray();
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
		System.out.println(result[3]);
		System.out.println(result[4]);

		System.out.println("--------------------------------");

		// Set의 모든 요소 확인
		for (Object x : hs) {
			System.out.println(x);
		}

		//

	}

}
