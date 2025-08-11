package com.Java8featues;

import java.util.Arrays;
import java.util.List;

public class Assignment_9 {

	public static void main(String[] args) {
		List<Integer> names=Arrays.asList(5,9,6,3,4,2);
		names.parallelStream()
			.forEach(n-> System.out.println("Squares of "+n+" :"+n*n));
			}

}
