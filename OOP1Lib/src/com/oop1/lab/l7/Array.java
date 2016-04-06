package com.oop1.lab.l7;

import java.util.Arrays;

public class Array {

	public static void reverseArray(int[] array){
		int temp;
		int count = 0;
		
		System.out.printf("Before reversal: %s%n", Arrays.toString(array));
		
		while(count < array.length/2){
			temp = array[count];
			array[count] = array[array.length-count-1];
			array[array.length-count-1] = temp;
			count++;
		}
		
		System.out.printf("After Reversal: %s%n", Arrays.toString(array));
	}
	
	 
	public static void main(String[] args) {
		int[] test = {1,2,3,4,5,6,7,8,9};
		Array.reverseArray(test);
	}
	


}
