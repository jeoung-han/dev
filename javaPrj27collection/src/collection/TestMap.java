package collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public void testMethod() {
		// Map > HashMap

		Map hm = new HashMap();

		/*
		 * key, value 쌍으로 데이터 저장 key 중복 불가능 value 중복 가능
		 * 
		 */

		// 값 넣기(키, 값)
		hm.put("one", "apple");
		hm.put("two", "apple");
		hm.put("two", "멜론");
		hm.put("three", "tomato");

		System.out.println("--------------------");
		System.out.println(hm.containsKey("one"));
		System.out.println(hm.containsValue("apple"));

		System.out.println(hm.isEmpty());

		hm.remove("one");

		// 몇개의 노드(요소)가 존재하는지
		System.out.println(hm.size());

		// 값 꺼내기
		System.out.println(hm.get("one"));
		System.out.println(hm.get("two"));
		System.out.println(hm.get("three"));
		System.out.println(hm.get("four"));

	}

}
