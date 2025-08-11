package com.Java8featues;

import java.util.Optional;
import java.util.Scanner;



public class Assignment_2 {
	public static Optional<String> divide(int dividend ,int divisor){
		if(dividend/divisor ==0) {
			return Optional.of("Not Allowed");
		}
		double result=(double)dividend/divisor;
		return Optional.of(String.valueOf(result));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		divide(a,b).ifPresent(System.out::println);
	}

}
