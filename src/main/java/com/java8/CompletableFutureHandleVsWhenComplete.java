package com.java8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureHandleVsWhenComplete {

	// Propogates to Actual Exception withinn SupllyAsync
	/*public static void main(String[] args) {
		CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("1");
		}).whenComplete((res, ex) -> {
			System.out.println("Result : " + res);
			throw new RuntimeException("2");
		}).join();
	}*/

	// Does not propogates to Actual Exception within SupllyAsync. Instead hanlder Excpetion will be considered
	public static void main(String[] args) {
		CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("1");
		}).handle((res, ex) -> {
			System.out.println("Result : " + res);
			throw new RuntimeException("2");
		}).join();
	}
}
