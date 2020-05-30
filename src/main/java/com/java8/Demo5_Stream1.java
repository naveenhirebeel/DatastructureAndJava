package com.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.naming.spi.InitialContextFactoryBuilder;

interface Test {
	
	default void test() {
		System.out.println("Hi");
	}
}

class Person {

	public String name;
	public int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
public class Demo5_Stream1 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		 printViaStream_1();
//		 printViaStream_2();
//		 printViaStream_3();
//		 printViaStream_4();
//		 streamSupplierExample();
//		 collectorsExample();
//		 parallelStreamExample();
//		 reduceDemo();

	}
	
	static void myPrint(String str) {
		System.out.println(str);
	}
	static void printViaStream_1() {
		
		//Consumer<String> c = str -> System.out.println(str);
		
		List<String> list = Arrays.asList("a1", "a2", "b1", "b2", "c2", "c1");
		list.stream()
		.filter(str -> {
			System.out.println("filter "+str);
			return str.startsWith("c");
		})
		// .forEach(c);
		// .forEach(str -> System.out.println(str));
		//.forEach(System.out::println);
		.forEach(Demo5_Stream1::myPrint);
	}

	static void printViaStream_2() {
		List<String> list = Arrays.asList("c1", "c2", "b1", "b1", "a2", "a1");
		/*list.stream().filter(str -> {
			System.out.println("Filter : " + str);
			return true;
		}).forEach(str -> System.out.println("For Each : " + str));*/
		
		list.stream().filter(str -> {
			System.out.println("Filter : " + str);
			return true;
		})
		.sorted()
		.map(s -> {
			System.out.println(s.toUpperCase());
			return s.toUpperCase();
		})
		.forEach(str -> System.out.println("For Each : " + str));
	}

	/*
	 * Here we can see Operations happen on every element one by one and all
	 * elements will be collected to list
	 */
	static void printViaStream_3() {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// get list of unique squares
		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct()
				.collect(Collectors.toList());
		System.out.println(squaresList);
		
		long count = numbers.stream().map(i -> i * i).distinct()
				.count();
		System.out.println(count);
	}

	// Order of Operations.
	/* Here we can see Operations happen on every element one by one */
	static void printViaStream_4() {
		List<String> list = Arrays.asList("Mohan", "Neha", "Sagar", "Sukanya",
				"Abhi");
		list.stream().filter(str -> {
			System.out.println("Filter : " + str);
			return str.startsWith("S");
		}).map(str -> {
			System.out.println("Map : " + str);
			return str.toUpperCase();
		}).forEach(str -> System.out.println(str));
	}

	// Ternary operations can be called only once in stream, but if you want
	// call them multiple times use Stream Supplier instead of creating new
	// Stream.
	static void streamSupplierExample() {
		
		//Supplier<Stream<String>> supplier = () -> Arrays.asList("a", "b", "c").stream();
		//List<String> list = Arrays.asList("a", "b", "c");
		
		Supplier<Stream<String>> streamSupplier = () -> Stream.of("a", "b", "c").filter(s -> {
			System.out.println("ddddd");
			return s.startsWith("d");
		});
		long count = streamSupplier.get().count();
		System.out.println("Count : " + count);
		streamSupplier.get().forEach(s -> System.out.print(s));

	}

	static void collectorsExample() {
		List<Person> persons = Arrays.asList(
				new Person("Neha", 18),
				new Person("Jaya", 24), 
				new Person("Piyush", 24), 
				new Person("Pratiyusha", 20));

		IntSummaryStatistics ageSummary = 
				persons
					.stream()
					.collect(Collectors.summarizingInt(p -> p.age));
		System.out.println(ageSummary);
		
	}
	
	/*
	By Default Threads will be created depend upon number of Cores your Processor has. 
	We can modify number of parralel threads by following env varible
	
	-Djava.util.concurrent.ForkJoinPool.common.parallelism=12
	
	*/
	static void parallelStreamExample() throws InterruptedException, ExecutionException {

		List<Person> persons = Arrays.asList(new Person("Neha", 18), new Person("Jaya", 24), new Person("Piyush", 24),
				new Person("Pratiyusha", 20), new Person("Piyush", 24), new Person("Neha", 18), new Person("Jaya", 24),
				new Person("Piyush", 24), new Person("Pratiyusha", 20), new Person("Piyush", 24),
				new Person("Pratiyusha", 20));

		// Using ForkJoinPool.commonPool() ->
		// This pool will be used by all default parralel Stream running under this JVM.

		/*System.out.println(ForkJoinPool.getCommonPoolParallelism());
		persons.parallelStream().forEach(p -> {
			System.out.println(Thread.currentThread().getName());
		});*/

		// This Code will not Use ForkJoinPool.commonPool() instead it uses its own
		// ForkJoinPool.
		/*new ForkJoinPool(4).submit(() -> persons.parallelStream().forEach(p -> {
			System.out.println(Thread.currentThread().getName());
		})).get();*/
		//})).get();
		
		System.out.println(ForkJoinPool.getCommonPoolParallelism());
		List<Integer> list = persons.parallelStream().map(p -> p.getAge()).collect(Collectors.toList());
		System.out.println(list);

	}
	
	public static void reduceDemo() {
		int[] array = { 23, 43, 56, 97, 32 };
		
		IntBinaryOperator ibo = (x, y) -> {
			return x+y;
		};
		
		// By default start value is 0. Result will be sum of array.
		Arrays.stream(array).reduce(
				ibo
				).ifPresent(s -> System.out.println(s));
	}
}

