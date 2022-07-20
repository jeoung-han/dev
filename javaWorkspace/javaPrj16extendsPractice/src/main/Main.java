package main;

import java.util.Arrays;

import mob.Pairi;
import mob.Pikachu;
import mob.Pokemon;
import mob.Turtle;

public class Main {

	public static void main(String[] args) {
		// 포켓몬 생성
		Pokemon pikachu = new Pikachu();
		Pokemon pairi = new Pairi();
		Pokemon turtle = new Turtle();
		
		Pokemon[] pArr = new Pokemon[3];
		pArr[0] = pikachu;
		pArr[1] = pairi;
		pArr[2] = turtle;

		// 모든 포켓몬 몸통 박치기
		for(Pokemon p : pArr) {
			p.bodyAttack();
			p.skill();
		}
		
		System.out.println(Arrays.toString(pArr));

//		// 모든 포켓몬 스킬 사용
//		pikachu.skill();
//		pairi.skill();
//		turtle.skill();

	}

}
