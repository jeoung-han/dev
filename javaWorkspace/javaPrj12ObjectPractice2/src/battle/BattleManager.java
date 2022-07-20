package battle;

import mob.Pokemon;

public class BattleManager {

	public void battleStart(Pokemon user, Pokemon enemy) {

		boolean isFinish = false;
		do {
			// 공격하기
			user.attack();
			calcDamage(user, enemy);
			// 판단
			isFinish = checkDead(enemy);
			if (isFinish) {
				break;
			}
			// 공격하기
			enemy.attack();
			calcDamage(enemy, user);
			// 판단
			isFinish = checkDead(user);

		} while (!isFinish);

		System.out.println("배틀종료!");

	}

	public boolean checkDead(Pokemon poke) {
		if (poke.getHp() <= 0) {
			System.out.println(poke.getName() + "죽음 ... ㅜㅜ");
			return true;
		} else {
			return false;
		}
	}

	// 데미지 계산
	public void calcDamage(Pokemon attacker, Pokemon defender) {
		int result = defender.getHp() - attacker.getAtk();
		defender.setHp(result);
		System.out.println("데미지 : " + attacker.getAtk());
		System.out.println(defender.getName() + " 의 남은 체력 : " + defender.getHp());
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	}

	// 때림
//	public void fight(Pokemon attacker, Pokemon defender) {
//		attacker.attack();
//	}

}
