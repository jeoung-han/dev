package generic;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	public void testMethod() {
		
		List <Integer>scoreList = new ArrayList<Integer>();
		
		scoreList.add(80);
		scoreList.add(77);
		scoreList.add(100);
		
		int result = 0;
		result += scoreList.get(0);
		
		scoreList.forEach(null);
		
		
		
		
		
	}
	
}
