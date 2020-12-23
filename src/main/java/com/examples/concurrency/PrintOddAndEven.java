package com.examples.concurrency;

public class PrintOddAndEven {

	public static void main(String[] args) {
		PrintSequenceRunnable runnable1 = new PrintSequenceRunnable(1);
		PrintSequenceRunnable runnable2 = new PrintSequenceRunnable(0);
		Thread t1 = new Thread(runnable1, "T1");
		Thread t2 = new Thread(runnable2, "T2");
		t1.start();
		t2.start();
	}
}

class PrintSequenceRunnable implements Runnable {

	public int PRINT_NUMBERS_UPTO = 100;
	static int number = 0;
	int remainder;
	static Object lock = new Object();

	PrintSequenceRunnable(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (number < PRINT_NUMBERS_UPTO - 1) {
			synchronized (lock) {
				while (number % 2 != remainder) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}
}


