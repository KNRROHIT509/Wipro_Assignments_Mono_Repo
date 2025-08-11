package com.Java8featues;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Assignment_12 {
	public static void main(String[] args) {
		List<String> names=Arrays.asList("jacob", "davey" ,"david" ,"Adam" ,"Alaister" );
		names.stream()
			.sorted()
			.forEach(System.out::println);
				
	}

}
