package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Demo3_ConsumerDemo {

	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Uday", "Neha", "Harish", "Abc", "Xyz", "Jignesh", "JolySingh");
		Consumer<String> c = obj -> System.out.println(obj + " ");
		list.forEach(c);
	}
}
