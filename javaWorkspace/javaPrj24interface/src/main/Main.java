package main;

import car.Car;

public class Main {

	public static void main(String[] args) {

		//인터페이스
		//메소드는 추상메소드 만 가질 수 있다
		
		Car car01 = new Sonata();
		car01.go();
		car01.stop();
		
		
	}

}
