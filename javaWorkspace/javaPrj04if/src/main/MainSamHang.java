package main;

public class MainSamHang {
	
	public static void main(String[] args) {
			
		int x = -3;
		int result = 0;
		
		if(x>0) {
			result = 1;
		}else {
			result = -1;
		}
		
		System.out.println(result);
		
		result = (x>0) ? 1 : -1;
		result = (x>0) ? 1 : (x==0) ? 0 : -1;
		
		System.out.println(result);
		
	}

}
