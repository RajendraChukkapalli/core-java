package com.examples.corejava.Java8;

import java.util.Optional;

public class OptionalExample {

    public static void main( String[] args ) {

        String s = null;
        Optional<String> temp = Optional.empty();
        Optional<String> s1 = Optional.of(s);
        System.out.println(s1.orElse("A"));

    }

}
