package mob;

public class Padak extends Digimon /*implements DigimonAction*/{

	@Override
	public void attack() {
		System.out.println(getName() + " 공격!");
	}

	@Override
	public void skill() {
		System.out.println(getName() + " 공기팡!");
	}



}
