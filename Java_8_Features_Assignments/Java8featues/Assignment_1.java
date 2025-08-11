package com.Java8featues;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Assignment_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names=Arrays.asList("rohit","tarun","ajay","mohana","harish");
		Stream<String> data=names.stream()
				.sorted();
		data.forEach(n-> System.out.println(n));
		

	}

}
