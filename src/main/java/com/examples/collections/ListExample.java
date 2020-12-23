package com.examples.collections;

import java.util.*;
import java.util.function.Consumer;

/**
 * Generate Pascal Triangle
 *
 */
public class ListExample {

	public static void main(String[] args) {
		List<List<Integer>> pascalList = new ArrayList<>();
		int currentRow = 0;
		int maxRows = 5;
		while (currentRow < maxRows) {
			List<Integer>  tempList = new ArrayList<>(); 
			if (currentRow == 0) {
				tempList.add(1);
			} else if (currentRow == 1) {
				tempList.add(1);
				tempList.add(1);
			} else {
				tempList.add(1);
				// logic to add previous row numbers
				for (int i = 1; i < currentRow ; i++) {
					List<Integer> intList = pascalList.get(currentRow-1);
					tempList.add(intList.get(i) + intList.get(i-1));
				}
				tempList.add(1);
			}
			pascalList.add(tempList);
			currentRow += 1;
		}
		pascalList.stream().forEach(n -> System.out.println( " " + n  + " "));
		
//		pascalList.stream().forEach(new Consumer<List<Integer>>() {
//			@Override
//			public void accept(List<Integer> t) {
//				pascalList.stream().forEach(n -> System.out.println( " " + n  + " "));
//			}
//		});
		
	}
}
