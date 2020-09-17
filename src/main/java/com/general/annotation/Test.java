package com.general.annotation;

@TestAnnotation(version = "2")
public class Test {

	public static void main(String[] args) {

		Test t = new Test();

		Class c = t.getClass();
		TestAnnotation ta = (TestAnnotation) c.getAnnotation(TestAnnotation.class);
		System.out.println(ta.version());
		
	}
}
