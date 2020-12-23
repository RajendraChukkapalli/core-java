package com.examples.corejava.java8;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 *  Java8 also provides IntStream, LongStream, DoubleStream and provide 
 *  all the aggregate functions.
 *
 */
public class StreamsGetMin {

	public static void main(String[] args) {
		
		int [] intArray = {1,45,34,28,90,-10, -1,199};
		
		int min = getMinValue(intArray);
		System.out.println(min);
		
		int min2 = getMinValueUsingStreams(intArray);
		System.out.println(min2);
		
	}

	/**
	 * Streams does all the aggregate operations like min, max, average etc
	 * 
	 * @param intArray
	 * @return
	 */
	private static int getMinValueUsingStreams(int[] intArray) {
		       
		return  IntStream.of(intArray)
				        .sorted()
				        .filter(new IntPredicate() {
							@Override
							public boolean test(int value) {
								return (value > 0);
							}})
				        .min()
				        .getAsInt();
	}

	/**
	 * Sort the array and get the first element
	 * @param intArray
	 * @return
	 */
	private static int getMinValue(int[] intArray) {
		Arrays.sort(intArray);
		return intArray[0];
	}
}
