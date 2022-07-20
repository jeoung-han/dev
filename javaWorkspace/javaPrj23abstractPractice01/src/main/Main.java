package main;

import car.Car;
import car.henz.Glc;
import car.henz.Gls;
import car.tesla.Model3;
import car.tesla.ModelX;

public class Main {

	public static void main(String[] args) {

		System.out.println("====추상메소드 연습====");
		
		Car[] carArr = new Car[4];
		carArr[0] = new Model3();
		carArr[1] = new ModelX();
		carArr[2] = new Gls();
		carArr[3] = new Glc();
		
		for(Car c : carArr) {
			c.go();
		}

		
		
		
		
		
			
	}

}
