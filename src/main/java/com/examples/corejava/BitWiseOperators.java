package com.examples.corejava;

/**
 * & - BitWise AND
 * | - BitWise OR
 * ^ - BitWise XOR
 * ~ - Bitwise complement
 * 
 */
public class BitWiseOperators {
	public static void main(String[] args) {
		
		// & - BitWise AND 
		// 5 - binary -  0101 
		// 7 - binary -  0111 
		// 5 & 7 =>      0101
		int a = 5;
		int b = 7;
		System.out.println(a&b);
	}
}