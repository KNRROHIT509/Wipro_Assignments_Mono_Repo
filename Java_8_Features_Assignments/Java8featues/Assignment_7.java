package com.Java8featues;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> names=Arrays.asList(5,9,6,3,4,2);
		Stream<Integer> data=names.stream();
		List<Integer> even=data.filter(n->n%2==0)
			.collect(Collectors.toList());
		System.out.println("Even numbers : "+even);
	}

}
