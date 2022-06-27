package collection;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	public void testMethod() {

		// List > ArrayList
		List al = new ArrayList();

		/*
		 * 순서 있음 (인덱스) 중복 가능
		 * 
		 */

		// 값 넣기
		al.add(10);
		al.add(20);
		al.add(30);
		al.add("40");
		al.add(50);
		al.add(50);
		al.add(50);

		// 값이 포함되어 있는지 확인
		System.out.println(al.contains(30));

		// 값의 사이즈(길이?) 확인
		System.out.println(al.size());

		// 요소의 삭제
//		al.remove(3);//index

		al.remove(new Integer(10));// 요소

		// 요소의 인덱스 확인
		System.out.println(al.indexOf(50));
		System.out.println(al.lastIndexOf(50));

		// 특정 인덱스의 값 바꾸기
		al.set(0, 99);

		// 모든요소 제거
//		al.clear();

		// 리스트 비어있는지 확인
		System.out.println(al.isEmpty());

		al.add(3, 777);

		System.out.println("-----------------------------------------------------");

		// 값 확인
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));

		}

	}

}
