package com.datastructure.recursion;

public class TOH {
	
	public static void main(String[] args) {
		new TOH().place(3, 'A', 'C', 'B');
	}
	
	private void place(int numberOfDisks, Character from, Character to, Character aux) {
		
		if(numberOfDisks == 1) {
			System.out.println("move from " + from + " to "+ to);
		} else {
			place(numberOfDisks - 1, from, aux, to);
			System.out.println("move from "+ from + " to " + to);
			place(numberOfDisks - 1, aux, to, from);
		}
		
		
		
	}

}
