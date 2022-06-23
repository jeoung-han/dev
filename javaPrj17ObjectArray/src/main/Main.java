package main;

import java.util.Iterator;

import person.Person;

public class Main {

	public static void main(String[] args) {

		System.out.println("객체 배열");	
		Person[] personArr = new Person[5];
		personArr[0] = new Person("심원용", "한국", 20, 'M');
		personArr[1] = new Person("심투용", "한국", 21, 'M');
		personArr[2] = new Person("심삼용", "한국", 22, 'M');
		personArr[3] = new Person("심사용", "한국", 23, 'M');
		personArr[4] = new Person("심오용", "한국", 24, 'M');
		
		for(Person p : personArr) {
			System.out.println(p);
		}
		
		
		
		
	
		
	}

}
