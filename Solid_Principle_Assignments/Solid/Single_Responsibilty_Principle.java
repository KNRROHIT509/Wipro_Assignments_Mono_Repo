package com.Solid;
//Login Page
class username{
	String name;
	username(String name) {
		this.name=name;
	}
	void display() {
		System.out.println("Single Responsibility of username "+this.name);
	}
}
class password{
	int pwd;
	password(int pwd) {
		this.pwd=pwd;
	}
	void display() {
		System.out.println("Single Responsibility of password "+this.pwd);
	}
}

public class Single_Responsibilty_Principle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		username u=new username("Rohit");
		u.display();
		password p=new password(1234);
		p.display();
	}
}
