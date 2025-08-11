package com.Java8featues;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Assignment_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names=Arrays.asList("Alaska", "Alex" ,"David" ,"Sara" ,"Alaister","Amanda","Tara" );
		Predicate<String> isStart=n->n.charAt(0) == 'A';
		Predicate<String> isEnd=n->n.charAt(n.length()-1) == 'a';
			System.out.println("Names with start with a and ends with a");
			names.stream()
				.filter(isStart.and(isEnd))
				.forEach(n->System.out.print(n+" "));
			System.out.println();
			System.out.println();
			System.out.println("Names with start with a or ends with a");
			names.stream()
			.filter(isStart.or(isEnd))
			.forEach(n->System.out.print(n+" "));
			System.out.println();
			System.out.println();
			System.out.println("Names with not start with a" );
			names.stream()
			.filter(isStart.negate())
			.forEach(n->System.out.print(n+" "));
	}

}
