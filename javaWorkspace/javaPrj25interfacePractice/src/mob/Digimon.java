package mob;

public abstract class Digimon implements DigimonAction{
	
	// data
	protected String name;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void attack() {
		System.out.println("asdf");
	};

	@Override
	public String toString() {
		return "Digimon [name=" + name + ", type=" + type + "]";
	}
	
	public void sayHello() {
		System.out.println("나는 디지몬이야 ㅎㅎ");
	}

}
