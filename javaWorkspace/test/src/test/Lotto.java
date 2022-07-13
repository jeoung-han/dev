package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] results = solution(lottos, win_nums);
		System.out.println(results[0]);
		System.out.println(results[1]);
	}
    public static int[] solution(int[] lottos, int[] win_nums) {
//    	System.out.println(scan(lottos, win_nums));
//    	System.out.println();
//    	System.out.println(scan(lottos, win_nums) + countZero(lottos));
        int a = result(scan(lottos, win_nums) + countZero(lottos));
        int b = result(scan(lottos, win_nums));
        
    	int[] answer = {a, b};
        return answer;
    }
    private static int countZero(int[] arr) {
    	List<Integer> arrList = Arrays.stream(arr).boxed().toList();
//    	System.out.println(Collections.frequency(arrList, 0));
    	return Collections.frequency(arrList, 0);
    }
    
    private static int scan(int[] lotto ,int[] win){
    	List<Integer> intList = new ArrayList<Integer>(win.length);
        List<Integer> winList = Arrays.stream(win).boxed().toList();
        int result = 0;
        for(int l : lotto) {
//        	System.out.println(winList.contains(l));
        	if(winList.contains(l)) {
        		result++;
        	}
        }
        return result;
    }
    
    private static int result(int n){
        switch(n){
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default : return 6;
        }
    }

}
