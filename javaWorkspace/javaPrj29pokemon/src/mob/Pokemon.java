package mob;

public abstract class Pokemon {

	public Pokemon(String name, int atk, int def, int hp) {
		super();
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.hp = hp;
	}

	private String name;
	private int atk;
	private int def;
	private int hp;

	public abstract void bodyAttack();

	public abstract void skill();

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", atk=" + atk + ", def=" + def + ", hp=" + hp + "]";
	}
	

}
