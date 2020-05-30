package com.general.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Demo4_PredicateDemo {

	// Predicate Example
	/*public static void main(String[] args) {
		List<String> languages = Arrays.asList("Uday", "Neha", "Harish", "Abc", "Xyz", "Jignesh", "JolySingh");
		System.out.println("Name Start With J");
		myMethod(languages, str -> str.startsWith("J"));
	}

	static void myMethod(List<String> list, Predicate<String> condition) {
		list.forEach(obj -> {
			if (condition.test(obj)) {
				System.out.println(obj + " ");
			}
		});
	}*/

	 //---------BiPredicate------------
	/*public static void main(String[] args) {
		BiPredicate<Integer, String> condition = (i, s) -> i > 20 && s.startsWith("J");
		System.out.println(condition.test(10, "Jaya"));
		System.out.println(condition.test(40, "Maya"));
		System.out.println(condition.test(30, "Jignesh"));
	}*/

}
