package com.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {

	Integer id;
	String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id : "+id+ ", name : "+name;
	}
}

public class Demo2_ComparatorUsingLambda {

	public static void main(String[] args) {
		Employee e1 = new Employee(2, "Neha");
		Employee e2 = new Employee(4, "Raja");
		Employee e3 = new Employee(3, "Arushi");
		Employee e4 = new Employee(1, "Abhi");
		
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		Comparator<Employee> c = (emp1, emp2) -> emp1.getId().compareTo(emp2.getId());
		Collections.sort(list, c);
		System.out.println(list);
		
		System.out.println();
		list.forEach(o -> System.out.println(o));
		
	}
}
