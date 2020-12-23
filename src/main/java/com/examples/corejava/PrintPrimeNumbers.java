package com.examples.corejava;

/**
 * A prime number is a number which has only two divisors 1 and itself.
 * which means there should be only 2 factors.
 *
 */
public class PrintPrimeNumbers {
	
	public static void main(String[] args) {
		for (int i=0; i < 100; i++) {
			if(isPrimeNumber(i)) {
				System.out.print(" "+i);
			}
		}
	}
	
	public static boolean isPrimeNumber(int number) {
		   if (number <= 1) {
		       return false;
		   }
		   for (int i = 2; i <= Math.sqrt(number); i++) {
		       if (number % i == 0) {
		           return false;
		       }
		   }
		   return true;
	}
}
