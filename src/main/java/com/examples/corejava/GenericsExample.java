package com.examples.corejava;

/**
 * The most commonly used type parameter names are:
 * 
 * T - Type
 * E - Element
 * K - Key 
 * V - Value 
 * S, U, V - 2nd, 3rd, 4th types etc
 * N - Number
 * 
 * Type Inference: compiler can determine, or infer, the type arguments from the context
 * 
 */
public class GenericsExample {

	public static void main(String[] args) {
		Box<Integer>  intBox = new Box<>(5);
		System.out.println(intBox.get());
		
		Box<String>  string = new Box<>("Hello");
		System.out.println(string.get());
		
		// create two instantiations of the OrderedPair class
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
		System.out.println("key" + p1.getKey() + "value" + p1.getValue());
		Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
		System.out.println("key" + p2.getKey() + "value" + p2.getValue());
		
		// generic methods example
		Pair<Integer, String> p3 = new OrderedPair<>(1, "1");
		Pair<Integer, String> p4 = new OrderedPair<>(2, "Pear");
		
		System.out.println(GenericMethodsUtil.compare(p3, p4));
	}
}


class Box<T> {
    private T t;
    public Box(T t) {
    	this.t = t;
    }
    public void set(T t) { this.t = t; }
    public T get() { return t; }
}


interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
	this.key = key;
	this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
}


/**
 * Generic methods example:
 * 
 * Why we have to mention generic type parameter before the method return type?
 *   - the method is static so it doesn't 'see' the generic types of the containing class.
 *
 */
 class GenericMethodsUtil {
    public static <K,V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
    
    public  boolean compareString(Pair<String, String> p1, Pair<String, String> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
}