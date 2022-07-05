package main;

import emp.CookEmployee;
import emp.CounterEmployee;
import emp.Employee;

public class Main {

	public static void main(String[] args) {

		System.out.println("==== 추상화 ====");
		
		Employee counterEmp = new CounterEmployee();
		Employee cookEmp = new CookEmployee();
		
		Employee[] empArr = new Employee[2];
		empArr[0] = counterEmp;
		empArr[1] = cookEmp;
		
		empArr[0].clean();
		empArr[1].clean();
		
		double a = 2.2;
		int n = (int) a;
		
		((CounterEmployee) counterEmp).sayHello();
		
	}

}
