package com.company;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        //CHALLENGE 9 and 10 my version
        topNames2015
                .stream()
                .map (s ->s.substring(0,1).toUpperCase()+s.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out :: println);

        // CHALLENGE 9 TIMS VERSION
//        List<String> firstUpperCaseList = new ArrayList<>();
//        topNames2015.forEach( name ->
//                firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
//        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
//        firstUpperCaseList.forEach(s -> System.out.println(s));

        //challenge 10 METHOD REFERENCES
        List<String> firstUpperCaseList = new ArrayList<>();

        topNames2015.forEach( name ->
                firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out :: println);

        System.out.println("*********************************");
//CHALLENGE 12 MY VER
        System.out.println(topNames2015
                .stream()
                .map (s ->s.substring(0,1).toUpperCase()+s.substring(1))
                .filter(s -> s.startsWith("A"))
                .count());
//CHALLENGE 12 TIMS VER
        long namesBeginningWithA = topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println("Number of names beginning with A is : "+ namesBeginningWithA);
//CHALLENGE 14

        System.out.println(topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
//                .reduce((el1, el2) ->el1.length()<el2.length() ?el1 : el2));
   //             .count());
                .collect(Collectors.toList()));



        }

    }

