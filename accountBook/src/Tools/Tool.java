package Tools;

import java.util.List;
import java.util.Map;

import controller.FileInputCtr;
import controller.FileOutputCtr;
import user.User;

public class Tool {

	FileInputCtr fic = new FileInputCtr();
	FileOutputCtr foc = new FileOutputCtr();

	// 0 ■ | 1 날짜 | 2 입금,출금 | 3 카테고리 | 4 금액 | 5 메모

	public void writer(User user, String s) {
		foc.write(user.getMyfile(), s);
	}

	public void printList(User user) {
		List<Map<Integer, String>> list = fic.readHistory(user.getMyfile());
		int sum1 = 0;
		int sum2 = 0;
		
		for (Map<Integer, String> m : list) {
			if (m.get(2).equals("입금 ▲")) {
				String temp = m.get(4);
				sum1 += Integer.parseInt(temp.replaceAll(",", ""));
			} else if (m.get(2).equals("출금 ▼")) {
				String temp = m.get(4);
				sum2 += Integer.parseInt(temp.replaceAll(",", ""));
			}
			mapPrint(m);
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("   입금 계 : " + sum1 + "     출금 계 : " + sum2);
		System.out.println("---------------------------------------------------");
	}

	public void printHistory(User user, String title) {
		List<Map<Integer, String>> list = fic.readHistory(user.getMyfile());
		int sum1 = 0;
		int sum2 = 0;

		for (Map<Integer, String> m : list) {
			if (m.get(3).equals(title)) {
				if (m.get(2).equals("입금 ▲")) {
					String temp = m.get(4);
					sum1 += Integer.parseInt(temp.replaceAll(",", ""));
				} else if (m.get(2).equals("출금 ▼")) {
					String temp = m.get(4);
					sum2 += Integer.parseInt(temp.replaceAll(",", ""));
				}
				mapPrint(m);
			}
		}

		System.out.println("---------------------------------------------------");
		System.out.println("   입금 계 : " + sum1 + "     출금 계 : " + sum2);
		System.out.println("---------------------------------------------------");
	}

	public void printHistory(User user, int date) {
		List<Map<Integer, String>> list = fic.readHistory(user.getMyfile());
		int sum1 = 0;
		int sum2 = 0;
		
		for (Map<Integer, String> m : list) {
			if (m.get(1).equals(Integer.toString(date))) {
				if (m.get(2).equals("입금 ▲")) {
					String temp = m.get(4);
					sum1 += Integer.parseInt(temp.replaceAll(",", ""));
				} else if (m.get(2).equals("출금 ▼")) {
					String temp = m.get(4);
					sum2 += Integer.parseInt(temp.replaceAll(",", ""));
				}
				mapPrint(m);
			}
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("   입금 계 : " + sum1 + "     출금 계 : " + sum2);
		System.out.println("---------------------------------------------------");
	}

	public void printHistory(User user, boolean deposit) {
		String temp = "출금 ▼";
		if (deposit) {
			temp = "입금 ▲";
		}
		
		int sum1 = 0;
		int sum2 = 0;
		List<Map<Integer, String>> list = fic.readHistory(user.getMyfile());
		
		for (Map<Integer, String> m : list) {
			if (m.get(2).equals(temp)) {
				if (m.get(2).equals("입금 ▲")) {
					String temp2 = m.get(4);
					sum1 += Integer.parseInt(temp2.replaceAll(",", ""));
				} else if (m.get(2).equals("출금 ▼")) {
					String temp2 = m.get(4);
					sum2 += Integer.parseInt(temp2.replaceAll(",", ""));
				}
				mapPrint(m);
			}
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("   입금 계 : " + sum1 + "     출금 계 : " + sum2);
		System.out.println("---------------------------------------------------");
	}

	private void mapPrint(Map<Integer, String> map) {
		for (int i = 0; i < map.size() - 1; i++) {
			System.out.print(map.get(i));
			System.out.print("   ");
		}
		System.out.println(map.get(map.size()-1));
	}

}
