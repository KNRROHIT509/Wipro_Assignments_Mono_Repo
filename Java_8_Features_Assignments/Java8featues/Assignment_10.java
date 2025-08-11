package com.Java8featues;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class Assignment_10 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anna", "Anna", "Brian", "Bella", "Ben", "Cathy");

        Map<String, Long> nameCounts = names.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        System.out.println(nameCounts);
    }
}
