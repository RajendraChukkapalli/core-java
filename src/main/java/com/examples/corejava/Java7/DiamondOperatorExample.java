package com.examples.corejava.Java7;

import java.util.ArrayList;
import java.util.List;

/**
 * No need to define the type on the object side
 */
public class DiamondOperatorExample {

    public static void main( String[] args ) {

        List<String> stringList = new ArrayList<String>(); // before Java7

        // left side decides the type, you are trying to add
        List<String> stringList7 = new ArrayList<>();
        stringList7.add("a");
        stringList7.add("b");
        for(String a: stringList7) System.out.println(a);
    }
}
