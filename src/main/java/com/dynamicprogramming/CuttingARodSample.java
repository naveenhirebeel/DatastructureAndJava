package com.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class CuttingARodSample {

	/*It is just pseudo code*/ 
	public static void main(String[] args) {
		//Length of 5
		Integer[] totalLength = {1,2,3,4,5};
		Integer[] pieces = {1,2,3,4};
		Integer[] price = {2,5,9,6};
		
		System.out.println("totalpieces "+pieces.length);
		System.out.println("totalLength "+totalLength.length);
		
		int[][] a = new int[pieces.length+1][totalLength.length+1];
		System.out.println(a.length);
		System.out.println(a[0].length);
		
		for(int i = 0; i <= pieces.length; i++ ) {
			for(int j = 0; j <= totalLength.length; j++) {
				if(i == 0 || j == 0) {
					a[i][j] = 0;
				} else if(totalLength[j-1] < pieces[i-1]) {
					a[i][j] = a[i-1][j];
				} else {
					int j1 = totalLength[j-1] - pieces[i-1];
					a[i][j] = Math.max(a[i-1][j], price[i-1] + a[i][j1]);
				}
			}
		}
		
		printGrid(a);
		
	}
	
	static void printGrid(int grid[][]) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				System.out.print(grid[row][col] + " ");
			}
			System.out.println();
		}
	}
}
