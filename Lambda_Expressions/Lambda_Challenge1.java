package com.company;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	new Thread(() -> {
	    String myString = "Let's split this up into an array";
	    String [] parts = myString.split(" ");

        Arrays.stream(parts).forEach(System.out :: println);

//	    for (String part : parts) {
//            System.out.println(part);

//        }
        }).start();
    }
}
