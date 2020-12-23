package com.examples.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Predicate;

/**
 * Java Priority queue is an implementation of "minHeap" can be
 * converted into max heap using a comparator.
 * 
 * Also Predicate is used to filter the elements from the heap. 
 * 
 *  min-heap = "lowest element" is at the top (root) and all the child are greater
 *  than the top element (root)
 *  
 *  max-heap - "max element" is at the top (root) and all the child
 *  are lower than the top element.
 *  
 *  You can get the min and max elements in O(1) time complexity.
 *
 */
public class PriorityQueueExample {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(10);
		
		pq.add(80);
		pq.add(75);
		pq.add(60);
		pq.add(-1);
		pq.add(2000);
		pq.add(-100);

		// filter the elements from the priority queue
		pq.stream().filter(new Predicate<Integer>() {
					@Override
					public boolean test(Integer t) {
						return t <= 0 ? false : true;
					}})
				   .forEach(a ->  System.out.print(a.intValue() + "  "));
		
		while(pq.size() > 0) {
			System.out.println(pq.remove());
		}
		System.out.println("-----------------------");
		//  Create a priority queue which puts the elements like max heap
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
									@Override
									public int compare(Integer o1, Integer o2) {
										 return o2.intValue() - o1.intValue();
										// return -1 * o1.compareTo(o2);
									}});
		//PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		pq2.add(80);
		pq2.add(75);
		pq2.add(60);
		pq2.add(-1);
		pq2.add(2000);
		pq2.add(-100);
		System.out.println();
		pq2.stream().forEach(a -> System.out.print(a.intValue() + "  "));
		System.out.println();
		
		while(pq2.size() > 0) {
			System.out.println(pq2.remove());
		}
	}
}
	
