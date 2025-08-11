package com.Java8featues;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Assignment_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names=Arrays.asList("klinger", "david" ,"liamliving" ,"Adam" ,"Alaister" );
		Stream<String> data=names.stream();
		Long total=data.filter(n->n.length()>5)
				.count();
		System.out.println("Names with length greater than five : " + total);

	}

}
