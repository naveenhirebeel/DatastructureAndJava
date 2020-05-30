package com.java8;

interface DemoInterface {
	
	default void test() {
		System.out.println("Yes I can have method implementation in JAVA 8");
	}

	default void print(String str) {
		if (!isNull(str)) {
			System.out.println("My data : " + str);
		}
	}

	static boolean isNull(String str) {
		System.out.println("Null Check");
		return null == str ? true : "".equals(str) ? true : false;
	}
}

public class Demo7_InterfaceMethods implements DemoInterface {

	public static void main(String[] args) {
		new Demo7_InterfaceMethods().print("Hi");
	}

}
