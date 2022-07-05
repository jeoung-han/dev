package emp;

public class CookEmployee extends Employee {

	// data

	// method
	public void cook() {
		System.out.println("요리합니다 ~");
	}

	@Override
	public void clean() {
		System.out.println("주방 청소합니다");
	}

}
