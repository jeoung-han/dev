package main;

import animal.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 상속 =====");
		
		Animal a01 = new Dog();
		Animal a02 = new Cat();
		Animal a03 = new Chicken();
		
//		a01.name = "바둑이";
//		a02.name = "야옹이";
//		a03.name = "페리카나";
//		
//		System.out.println(a01.name);
//		System.out.println(a02.name);
//		System.out.println(a03.name);
		
		a01.cry();
		a02.cry();
		a03.cry();
		

	}

}
