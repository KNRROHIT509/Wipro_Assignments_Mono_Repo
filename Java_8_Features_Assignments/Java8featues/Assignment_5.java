package com.Java8featues;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Assignment_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names=Arrays.asList("jacob", "david" ,"liam" ,"Adam" ,"Alaister" );
		Stream<String> data=names.stream();
		data.filter(n->n.charAt(0)=='A')
			.forEach(n->System.out.println(n));

	}

}
