package main;

import exception.TestException;

public class Main {

	public static void main(String[] args) {

		TestException te = new TestException();
		
		try {
			te.test01();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		
		
		
	}

}
