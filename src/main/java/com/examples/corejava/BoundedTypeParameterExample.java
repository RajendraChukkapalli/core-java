package com.examples.corejava;

/**
 * You can restrict the types that can be used as type arguments in a parameterized type.
 * 
 * For example, a method that operates on numbers might only want to accept instances of 
 * 	Number or its subclasses. 
 * 
 * BoundedTypes can be defined at both method or class 
 *
 */
public class BoundedTypeParameterExample {

	public static void main(String[] args) {
		Box2<Integer> integerBox = new Box2<Integer>();
        integerBox.set(Integer.valueOf(10));
        integerBox.inspect(Integer.valueOf(10));
	}

}

class Box2<T extends Number> {
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	// the "inspect" method is taking bounded type (like accepts any type of "Number" classes
	public void inspect(T t) {
		System.out.println("T: " + t.getClass().getName());
	}
}