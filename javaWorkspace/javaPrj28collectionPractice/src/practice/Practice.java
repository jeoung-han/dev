package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Practice {

	public void test() {

		HashSet<String> set = new HashSet<String>();
		set.add("chicken");
		set.add("pizza");
		set.add("hamburger");
		set.add("pasta");
		System.out.println(set.toString());
		
		// set의 모든 요소 꺼내기

		

		for (String x : set) {
			System.out.println(x);
		}

//		System.out.println("--------------");
//		String[] arr = set.toArray();
//		for (String x : arr) {
//			System.out.println(x);
//		}

	}

}
