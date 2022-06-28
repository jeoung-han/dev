package person;

import java.util.HashMap;
import java.util.Map;

import mob.Pokemon;

public class Trainer {

	public Trainer(String name, int level) {
		this.name = name;
		this.level = level;
	}

	// data
	private String name;
	private int level;
	private final Map<String, Pokemon> pocket = new HashMap<>();

	// method
	public void pocketInfo() {
		System.out.println(pocket);
	}
	
	public int getPocketCnt() {
		return pocket.size();
	}
	
	public void addPokemon(Pokemon p) {
		pocket.put(p.getName(), p);
	}
	
	public Pokemon getPokemon(String name) {
		return pocket.get(name);
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (level > this.level) {
			this.level = level;
		}else {
			System.out.println("레벨은 현재 레벨보다 낮아질 수 없습니다.");
		}
	}
}
