package com.examples.corejava.java8;

public class DiamondPatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface A {
	public void m();
}

interface B extends A {
	public void mb();
}

interface C extends A {
	public void mc();
}

class ATest implements B,C {

	@Override
	public void m() {
		System.out.println("m");
	}

	@Override
	public void mc() {
		System.out.println("mc");
	}

	@Override
	public void mb() {
		System.out.println("mb");
	}
}