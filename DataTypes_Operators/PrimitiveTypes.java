package com.company;

public class Main {

    public static void main(String[] args) {
        byte myOwnByteVariable = 10;
        short myOwnShortVariable = 20 ;
        int myOwnIntVariable = 2147483647;
        long myOwnLongVariable = (50000L + 10L*(myOwnByteVariable + myOwnShortVariable + myOwnIntVariable));
        System.out.println(myOwnLongVariable);

        short shotTotal = (short) (1000 + 10* (myOwnByteVariable+ myOwnShortVariable + myOwnIntVariable));
    }
}
