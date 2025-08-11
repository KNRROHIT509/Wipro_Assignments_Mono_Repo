package com.Java8featues;

interface human{
	void work();
	default void eat() {
		System.out.println("Human need to eat compulsory");
	}
}
class man implements human{

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Human need to work for growth");
	}
	
}
public class Assignment_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		man m=new man();
		m.eat();
		m.work();
	}

}
