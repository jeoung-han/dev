package test;

public class NewId {

	public static void main(String[] args) {
		new Solution().solution("...!@BaT#*..y.abcdefghijklm.");
	}
	
	public static class Solution {
	    public String solution(String new_id) {
	    	String answer = "";
	        //1.
	        answer = new_id.toLowerCase();
	        System.out.println(answer);
	        //2.
	        answer = answer.replaceAll("[^\\.\\w_-]", "");
	        answer = answer.replaceAll("\\.+", ".");
	        answer = answer.replaceAll("^\\.|\\.$", "");
	        if(answer.equals("")) {answer = "a";}
	        if(answer.length()>15) {answer = answer.substring(0,14).replaceAll("\\.$", "");}
	        if(answer.length()<=2) {
	        	while(answer.length()!=3) {
	        		answer += answer.charAt(-1);
	        	}
	        }
	        
	        System.out.println(answer);
	        
	        return answer;
	    }
	}
	
}
