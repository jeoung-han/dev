package main;

import student.Student;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("=== 오브젝트 ===");
		
		Student s = new Student();
		s.age = 20;
		s.name = "심원용";
		s.score = 100;
		System.out.println("s.name : " + s.name);
		System.out.println("s.age : " + s.age);
		System.out.println("s.score : " + s.score);
		
		Student s2 = new Student();
		s2.age = 21;
		s2.name = "심투용";
		s2.score = 200;
		
		System.out.println("s2.name : " + s2.name);
		System.out.println("s2.age : " + s2.age);
		System.out.println("s2.score : " + s2.score);
		
//		Student[] students = new Student[20];
		
		s.hello();
		s2.student();
		
		
		
		
		
		
		
	}
	
	
}
