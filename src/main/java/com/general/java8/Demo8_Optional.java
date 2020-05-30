package com.general.java8;

import java.util.Optional;

class PrimeMinister {
	
	String name;

	public PrimeMinister() {
		// TODO Auto-generated constructor stub
	}
	
	public PrimeMinister(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

public class Demo8_Optional {

	public static void main(String[] args) {
		
		Optional<String> op = Optional.empty();
		System.out.println(op);
		System.out.println(op.isPresent());
		
		op = Optional.ofNullable(null);
		System.out.println(op);
		
		op = Optional.ofNullable(null);
		System.out.println(op.isPresent());
		System.out.println(op.orElse("Default"));
		
		op = Optional.ofNullable("Some Value");
		System.out.println(op.isPresent());
		System.out.println(op.orElse("Default"));
		
		Optional<PrimeMinister> pm = Optional.of(new PrimeMinister());
		String pmName =  pm.map(PrimeMinister :: getName).orElse(Demo8_Optional.getName());
		System.out.println(pm.isPresent());
		System.out.println(pmName);
		
		//orElse will called passed method at any cost. orElseGet will call passed Supplier Object if Optional Object is Empty
		Optional<PrimeMinister> pm1 = Optional.of(new PrimeMinister("Narendra Modi"));
		String pmName1 =  pm1.map(PrimeMinister :: getName).orElse(Demo8_Optional.getName());
		System.out.println(pmName1);
		
	}
	
	private static String getName() {
		System.out.println("Called...");
		return "Namo";

	}
}
