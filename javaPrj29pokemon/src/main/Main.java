package main;

import java.util.Map;

import mob.Pikachu;
import person.Trainer;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== 포켓몬 =====");

		Trainer t = new Trainer("지우", 1);
		
		Pikachu p = new Pikachu("피카츄", 7, 3, 100);
		
		t.addPokemon(p);
		System.out.println(t.getPocketCnt());
		t.pocketInfo();
	}

}
