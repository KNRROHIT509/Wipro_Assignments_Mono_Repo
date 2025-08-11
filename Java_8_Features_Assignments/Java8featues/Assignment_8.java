package com.Java8featues;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names=Arrays.asList("jacob", "david" ,"liam" ,"Adam" ,"Alaister" );
		Stream<String> data=names.stream();
		String pretty_joiner=data.collect(Collectors.joining(","));
		System.out.println(pretty_joiner);
	}

}
