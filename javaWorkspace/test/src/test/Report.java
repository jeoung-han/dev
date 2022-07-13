package test;

class Report {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		String[][] temp2 = new String[id_list.length][id_list.length - 1];

		for (int i = 0; i < report.length; i++) {
			String[] temp = new String[2];
			temp = report[i].split("\\s+");
			
			int index;
			index = getEqualIndex(temp[1], id_list);
			
			include(temp[0],temp2[index]);
		}
		
		for (int i = 0; i<temp2.length; i++) {
			if(notNullCount(temp2[i])>=k) {
				for(String s : temp2[i]) {
					if(s==null) {
						
					}else {
						int index;
						index = getEqualIndex(s, id_list);
						answer[index] += 1;
					}
				}
			}
			
		}	

		return answer;
	}
	public int getEqualIndex(String s, String[] arr) {
		int i = 0;
		for (; i < arr.length; i++) {
			if(s.equals(arr[i])) {
				return i;
				
			}
		}
		return i;
	}
	public void include(String s, String[] arr) {
		for(int i = 0; i<arr.length;i++) {
			if(arr[i]==null) {
				arr[i] = s;
				break;
			}else if (arr[i].equals(s)) {
				break;
			}
		}
	}
	public int notNullCount(String[] arr) {
		int count = 0;
		for(String s : arr) {
			if(s==null) {
				
			}else {
				count++;
			}
		}
		return count;
	}
}