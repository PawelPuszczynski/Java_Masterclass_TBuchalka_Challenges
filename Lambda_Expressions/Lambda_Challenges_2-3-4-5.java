package com.company;

import java.util.function.Function;

public class Main {
//public static String everySecondChar (String source) {
//    StringBuilder returnVal = new StringBuilder();
//    for (int i =0; i <source.length(); i++) {
//        if (i%2==1) {
//            returnVal.append(source.charAt(i));
//        }
//    }
//    return returnVal.toString();
//}

    public static void main(String[] args) {


      Function<String, String> lamdaFunction =  s -> {
    StringBuilder returnVal = new StringBuilder();
    for (int i =0; i <s.length(); i++) {
        if (i%2==1) {
            returnVal.append(s.charAt(i));
        }
    }
    return returnVal.toString();
};

        System.out.println(lamdaFunction.apply("1234567890"));
        System.out.println("**************************");
        String input = "1234567890";
        System.out.println(everySecondCharacter(lamdaFunction, input));
    }

    public static String everySecondCharacter(Function<String, String> lambdaFunction, String input ) {
        return lambdaFunction.apply(input);
    }
}
