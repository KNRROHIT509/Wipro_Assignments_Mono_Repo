package com.Java8featues;

@FunctionalInterface
interface Greeting{
	void greet();
}
public class Assignment_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greeting g=()->System.out.println("Welcome to my party");
		g.greet();
	}

}
