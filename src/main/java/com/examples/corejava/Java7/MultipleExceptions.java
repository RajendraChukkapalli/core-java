package com.examples.corejava.Java7;

/**
 * Avoid multiple catch statements
 */
public class MultipleExceptions {

    public static void main( String[] args ) {
        try {
            int i = 1 / 0;
        } catch(NullPointerException | ArithmeticException ex) {
            String errorMessage = ex.getMessage();
            System.out.println("exception_message=" +errorMessage );
            System.out.println("exception_type=" + ex.getClass().getName());
        }
    }
}
