package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileInputCtr {

	// 0 ■ | 1 날짜 | 2 입금,출금 | 3 카테고리 | 4 금액 | 5 메모

	public String read(File f) {
		String temp = "";
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			temp = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return temp;
	}

	public List<String> readAll(File f) {

		List<String> sList = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			sList = new ArrayList<>();
			String s = "";
			while ((s = br.readLine()) != null) {
				sList.add(s);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return sList;
	}

	public List<Map<Integer, String>> readHistory(File f) {
		List<Map<Integer, String>> sList = new ArrayList<Map<Integer, String>>();
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			sList = new ArrayList<>();
			String s = "";
			while ((s = br.readLine()) != null) {
				Map<Integer, String> map = new HashMap<>();
				String[] arr = s.split("\t");
				for (int i = 0; i < arr.length; i++) {
					map.put(i, arr[i]);
				}
				sList.add(map);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return sList;
	}

}
