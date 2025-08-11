package com.Solid;

class Bike {
	void run() {
		System.out.println("Bike runs");
	}
}

class Motor_Bike extends Bike{
	void sub_part() {
		super.run();
		System.out.println("Motor Bike is part of Bike");
	}
}

class Honda extends Motor_Bike{
	int mil;
	void mileage(int mil) {
		this.mil=mil;
		System.out.println("Honda Mileage is "+this.mil +" KMPL");
	}
}
public class Liskov_Substitution_Principle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Motor_Bike mb= new Honda();
		mb.sub_part();
	}

}
