package com.examples.corejava;

/**
 * The overriding method should have more 
 * The "private" modifier specifies that the member can only be accessed in its own class. 
 * 
 * The protected modifier specifies that the member can only be accessed within its own package (as with package-private) and, 
 * 				 in addition, by a subclass of its class in another package.
 */
public class OverridingExample {
	public static void main(String[] args) {
		TwoWheeler tw = new Bike();
		// System.out.println(tw.getRate());
		System.out.println(tw.getRate2());
	}
}

class TwoWheeler {
	int rate = 10; 
	private int getRate() {
		return rate;
	}
	
	public int getRate2() {
		return getRate();
	}
}
/**
 * if I mark the "getRate" method as "protected", 
 *    Cannot reduce the visibility of the inherited method from TwoWheeler.
 *    - Compile time issue.
 *    - visibility should be same or higher
 *    
 * What if I convert, the "getRate" from TwoWheeler class. 
 * - Since it is marked as "private" it cannot be accessed out of it. 
 *
 */
class Bike extends TwoWheeler {
	int rate = 150;
	protected int getRate() {
		return rate;
	}
}