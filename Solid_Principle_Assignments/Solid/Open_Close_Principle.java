package com.Solid;

interface laptop{
	void ram();
	void processor();
	void price();
	//Not modifying
}

 class HP implements laptop{
	 int ram_spec;
	 String proc_spec;
	 int price_spec;
	 HP(int ram, String processor,int price){
		 this.ram_spec=ram;
		 this.proc_spec=processor;
		 this.price_spec=price;
	 }
	@Override
	public void ram() {
		// TODO Auto-generated method stub
		System.out.println("Extensible "+ this.ram_spec+" GB ram");
	}

	@Override
	public void processor() {
		// TODO Auto-generated method stub
		System.out.println("Extensible processor "+ this.proc_spec);
	}

	@Override
	public void price() {
		// TODO Auto-generated method stub
		System.out.println("Extensible price "+ this.price_spec);
	}
	
}
public class Open_Close_Principle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HP hp=new HP(8,"AMD",50000);
		hp.ram();
		hp.processor();
		hp.price();
	}

}
