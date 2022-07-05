package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PracticeMap {

	public void test() {
		// 맵 만들고, 모든 키 값, 모든 value 확인
		Map<String, String> map = new HashMap<String, String>();

		map.put("one", "apple");
		map.put("two", "banana");
		map.put("three", "tomato");

		System.out.println(map);

//		System.out.println(map.entrySet());

		Set<String> ks = map.keySet();
		for (Object x : ks) {
			System.out.println(x);
			System.out.println(map.get(x));
		}

	}

	public void test2() {
		// 맵 만들고, 모든 키 값, 모든 value 확인
		Map<String, String> map = new HashMap<String, String>();

		map.put("apple", "red");
		map.put("banana", "yellow");
		map.put("grape", "purple");

		Set<Entry<String, String>> es = map.entrySet();
		for (Map.Entry<String, String> x : es) {
//			System.out.println(x.getKey());
//			System.out.println(x.getValue());
			System.out.printf("%-10s, %s\n", x.getKey(), x.getValue());
		}
//		System.out.println(ks);

	}
	
	public void test3() {
		// 맵 만들고, 모든 키 값, 모든 value 확인
		Map<String, String> map = new HashMap<String, String>();

		map.put("apple", "red");
		map.put("banana", "yellow");
		map.put("grape", "purple");

//		System.out.println(ks);

	}

}
