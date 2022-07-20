package animal;

public class Animal {
	
	public Animal(String name, double wegiht){
		this.name = name;
		this.wegiht = wegiht;
	}

	private String name;
	private double wegiht;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWegiht() {
		return wegiht;
	}
	public void setWegiht(double wegiht) {
		this.wegiht = wegiht;
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + ", wegiht=" + wegiht + "]";
	}
	
	
	
	
	
}
