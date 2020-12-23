package com.examples.practicetests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Optional<Integer> ops = Optional.of(null);
//		System.out.println(ops);
		
//		List<Integer> list = new ArrayList<>();
//		list.add(10);
//		list.add(12);
//		list.add(2);
//		list.add(4);
//		
//		Optional<Integer> i = list.stream().max(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o1 - o2;
//			}
//		});
//		System.out.println(i.get());
		
		Stream<Integer> s = Stream.of(1,2,3);
		System.out.println(s.peek(System.out::print).findAny().orElse(0));
		
		short[] rows = new short[9];
		short value = (short) (1 << '9' - '1');
		System.out.println(value);
		rows[0] = value;
		
		if ((value & rows[0]) > 0) {
			System.out.println(true);
		}
	}

}
