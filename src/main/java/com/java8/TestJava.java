package all;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;

public class TestJava {

	/*public static void main(String[] args) {
		AtomicBoolean ab = new AtomicBoolean();
		System.out.println(ab.compareAndSet(false, true));
		System.out.println(ab.get());
		System.out.println(ab.compareAndSet(false, true));
		System.out.println(ab.get());
	}*/
	
	
	/*public static void main(String[] args) {
		sFunction<Integer, Integer> fn = i -> {return 10 + i;};
		System.out.println(fn.apply(10));
		
		List<String> list = Arrays.asList("111", "222", "333", "444");
		//list.forEach(str -> System.out.println(str));
		
		Function<String, String> c = Hello :: sayHello;
		//list.forEach(c);
		System.out.println(c.apply("Works"));
		
	}*/
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc1", "abc2", "abc4");
		list.stream().filter(element -> {
			System.out.println("filter() was called : " + element);
			return element.contains("2");
		}).map(element -> {
			System.out.println("map() was called");
			return element.toUpperCase();
		}).forEach(element -> {
			System.out.println(element);
		});
	}
	
	/*public static void main(String[] args) {
		List<String> list = Arrays.asList("abc1", "abc2", "abc4");
		list.stream().filter(element -> {
			System.out.println("filter() was called : " + element);
			return element.contains("2");
		}).count();
	}*/
}

class Hello {
	public static String sayHello(String str) {
		return str;
	}
}

