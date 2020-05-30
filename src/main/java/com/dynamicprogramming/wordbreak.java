package com.dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class wordbreak {

	String[] dictionary = {"i", "like", "java"};
	
	boolean wordbreak(String str) {
		System.out.println("Input String is "+str);
		if(str.length() == 0) {
			return true;
		}
		
		for(int i = 1; i <= str.length(); i++) {
			String substr = str.substring(0, i);
			System.out.println("substr "+ substr);
			boolean isPresent = isPresent(substr);
			
			if(isPresent) {
				boolean result = this.wordbreak(str.substring(i));
				System.out.println("result "+substr);
				
				if(result) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean isPresent(String subString) {
		for(String str : dictionary) {
			if(str.equals(subString)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String str = "ilikejava";
		System.out.println("Final Result "+ new wordbreak().wordbreak(str));
	}
	
}
