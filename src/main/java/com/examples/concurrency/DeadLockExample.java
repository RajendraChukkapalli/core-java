package com.examples.cocurrency;

/**
 * Dead lock example
 * 
 * Create 2 objects and add a synchronized block on each other like below.
 * 
 * How to break a dead lock?  no way you can break it. you need to terminate it.
 *
 */
public class DeadLockExample {

	String s = "s"; 
	String s1 = "s1"; 
	
	public static void main(String[] args) {
		DeadLockExample d = new DeadLockExample();
		d.first.start();
		d.second.start();
	}
	
	Thread first = new Thread("T1") {
		public void run() {
			while (true) {
				synchronized(s) {
					synchronized(s1) {
						System.out.println(s   + "  "  + s1  +  " t1=" + Thread.currentThread().getName());
					}
				}
			}
		}
	};
	
	Thread second = new Thread("T2") {
		public void run() {
			while (true) {
				synchronized(s1) {
					synchronized(s) {
						System.out.println(s1   + "  "  + s  +  " t2=" + Thread.currentThread().getName());
					}
				}
			}
		}
	};
}
