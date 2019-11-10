package com.examples.corejava.Java8;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class LambdaExpresionsExample {

    private enum Fruit {


        apple (1, "1"),
        carrot (1, "1"),
        mango (1, "1"),
        orange (1, "1");

        Fruit( int i, String s ) {

        }

    }

    public static void main( String[] args ) {
        String[] namesList = {"Rajendra", "Anitha", "Krishna", "Karthik"};
//        TestComparator comparator = new TestComparator();
//        Arrays.sort(namesList, comparator);
//        for(String a : namesList) System.out.println(a);

//        Comparator<String> cmp = (first, second) -> first.compareTo(second);
//        Arrays.sort(namesList, cmp);
//        for(String a : namesList) System.out.println(a);

        int[] intArray = {10,34,56,90,-1,4};
        Stream<Integer> s  = Arrays.stream(intArray).map(Integer::new).mapToObj(new IntFunction<Integer>() {
            @Override
            public Integer apply( int value ) {
                if (value < 0 ) return null;
                return new Integer(value);
            }
        });

        s.forEach(a -> System.out.println(a));
    }
}
class TestComparator implements Comparator<String> {
    @Override
    public int compare( String o1, String o2 ) {
        return o1.compareTo(o2);
    }
}


