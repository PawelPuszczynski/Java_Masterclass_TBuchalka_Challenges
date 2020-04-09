package com.company;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
	Supplier <String> supplier = ()-> {
        return "I love Java";
    };


	Supplier<String> iLoveJavaSo = ()-> "I love Java!";

	String supplierResult = iLoveJavaSo.get();
        System.out.println(supplierResult);

    }

}
