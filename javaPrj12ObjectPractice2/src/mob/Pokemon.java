package mob;

public class Pokemon {

	//기본 생성자
	public Pokemon() {
		System.out.println("포켓몬 생성자 호출됨...");
	}
	
	//모든필드 매개변수 생성자
	public Pokemon(String name, int hp, int atk) {
		System.out.println("매개변수가 있는 생성자 호출됨 ~~~");
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}
	// data
	// 이름 공격력 hp
	private String name;
	private int atk;
	private int hp;

	// method
	// 공격하기 회피하기 도망가기
	public void attack() {
		System.out.println(name+"의 공격");
	}

	public void eavde() {
		System.out.println("회피");
	}

	public void giveUp() {
		System.out.println("도망");
	}

	//getter setter toString
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", atk=" + atk + ", hp=" + hp + "]";
	}

}
