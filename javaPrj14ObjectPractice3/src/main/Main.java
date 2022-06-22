package main;

import animal.Animal;
import person.Person;
import pokemon.Pokemon;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== 연습 =====");

		// 사람 2명 만들기
//		Person p1 = new Person("심원용", 20, 'M');
//		
//		Person p2 = new Person("심투용", 15, 'F');
//		
//		p2.sayHello();
		
		Person p1 = new Person("심원용", 20, 'm');
		Person p2 = new Person("심투용", 20, 'F');
//		
//		
		Animal a1 = new Animal("이상해",20);
		Animal a2 = new Animal("이상해",30);
		
		Pokemon poke1 = new Pokemon("피카츄", 10, 10);
		Pokemon poke2 = new Pokemon("꼬부기", 10, 10);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(a1);
		System.out.println(a2);
//		p1.sayHello();
	}

}
