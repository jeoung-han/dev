package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class TestIo {

	public void test() throws Exception {

		File f = new File("D:\\dev\\file\\hello.txt");
//		System.out.println(f.isFile());

		System.out.println("=========================읽어봐");
		FileInputStream fis = new FileInputStream(f);

//		int result = 0;
//		while((result = fis.read())!=-1) {
//			System.out.print((char)result);
//		}

		BufferedReader br = new BufferedReader(new FileReader(f));

//		for (int i = 0; i < 2; i++) {
//			String s = br.readLine();
//			System.out.println(s);
//		}
		String s = "";
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}
		
		br.close();

	}

	public void test2() throws Exception {
		//문자열 입력받기
		System.out.print("문자열 입력 : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		File f = new File("D:\\dev\\file\\hello.txt");
//		System.out.println(f.isFile());

		BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
		
		bw.write("\n");
		bw.write(str);
		bw.flush();
		
		bw.close();
		bw.write(str);
		bw.write(str);
		System.out.println("완료");

	}

}
