package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        System.out.println(challenge1.matches("I want a bike."));
        System.out.println(challenge1.matches("I want a b[\\w]{3}."));



        String regExp1 = "I want a (bike|ball).";
//        String regExp2 = "I want a \\w+.";
        System.out.println(challenge1.matches(regExp1));
        System.out.println(challenge2.matches(regExp1));

        String regExp3 = "I want a \\w+.";
        Pattern pattern1 = Pattern.compile(regExp3);
        Matcher matcher1 = pattern1.matcher("I want a ball.");
        System.out.println(matcher1.matches());

        //A NEW MATCHER INSTANCE - u don't have to reset the matcher
        matcher1 = pattern1.matcher(challenge2);
        System.out.println(matcher1.matches());

        //A NEW MATCHER INSTANCE - u don't have to reset the matcher
        matcher1 = pattern1.matcher(challenge1);
        System.out.println(matcher1.matches());

        String challenge4 = "Replace all blanks with underscores.";

        System.out.println(challenge4.replaceAll(" ", "_"));
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "zaaabcccccccdddefffg";
        System.out.println(challenge5.matches("a{3}bc{7}d{3}ef{3}g"));
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));

        System.out.println(challenge5.matches("^a{3}bc{7}d{3}ef{3}g$"));
        System.out.println(challenge5.replaceAll("^a{3}bc{7}d{3}ef{3}g$", "REPLACED"));

        String challenge7 = "abd.135";
        System.out.println(challenge7.matches("^\\w[^0-9_]*(?=[.])\\d*$"));
        System.out.println(challenge7.matches("^[a-zA-Z]+(?=[.])\\d+$"));
        System.out.println(challenge7.matches("^[a-zA-Z]+[.][\\d+]$"));

        System.out.println(challenge7.matches("^[A-Z][a-z]+\\.\\d+$"));

        System.out.println("--------------------------------------");
        String challenge8 = "abcd.135uvqz.7tzik.999";
//        String regExp8 = "([^\\d*])(\\d+)([^\\d*])";
//        String regExp8 = "(\\d+)";
        String regExp8 = "[A-Za-z]+\\.(\\d+)";
        Pattern pattern8 = Pattern.compile(regExp8);
        Matcher matcher8 = pattern8.matcher(challenge8);

        while(matcher8.find()) {
            System.out.println(matcher8.group(1));
        }
        System.out.println("--------------------------------------");

        String challenge9= "abcd.135\tuvqz.7\ttzik.99\n";
        System.out.println(challenge9);

//        String regExp9 = "[.*](\\d+)((?=\\t)|(?=\\n))";
        String regExp9 = "[A-Za-z]+\\.(\\d+)\\s";
        Pattern pattern9 = Pattern.compile(regExp9);
        Matcher matcher9 = pattern9.matcher(challenge9);
        int counter =0;
        while(matcher9.find()) {
            counter++;
            System.out.println("Occurrence no: "+counter+" Start : " + matcher9.start(1)+ " End : "+  (matcher9.end(1)-1));
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";

//        String regExp11 = "([{])(.+?)([}])";
        String regExp11 = "\\{(.+?)\\}";
        Pattern pattern11 = Pattern.compile(regExp11);
        Matcher matcher11 = pattern11.matcher(challenge11);

        while(matcher11.find()) {

            System.out.println(matcher11.group(1));
        }

        System.out.println("*************************************");
        String challenge11a = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {6, 24}, {11, 12}";
        String regExp11a = "\\{((\\d+), (\\d+))\\}";
        Pattern pattern11a = Pattern.compile(regExp11a);
        Matcher matcher11a = pattern11a.matcher(challenge11a);

        while(matcher11a.find()) {

            System.out.println(matcher11a.group(2)+" "+matcher11a.group(3));
        }

        String challenge12 = "11111";
        System.out.println(challenge12.matches("^\\d{5}$"));

        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})?$"));
















   }
}
