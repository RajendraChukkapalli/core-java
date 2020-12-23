package com.examples.corejava.java8;

import java.util.*;

/**
 * A higher order function is a function that either takes a function (method) as parameter, 
 * or returns a function after its execution. 
 *
 */
public class HigherOrderFunction {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("One");
		list.add("Abc");
		list.add("BCD");
		list.add("BCD");
		
		// Collections.sort is an higher order function as it takes
		// lambda expression as its parameter
		Collections.sort(list, (String a, String b) -> {
		    return a.compareTo(b);
		});

		System.out.println(list);  
	}

}
