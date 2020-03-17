package com.company;

import org.w3c.dom.ls.LSOutput;

public class Main {



    public static void main(String[] args) {

//	int count =6;
//	while (count !=6) {
//        System.out.println("Count value is " +count);
//        count++;
//    }
//	count =1;
//	while (true) {
//        if (count == 6) {
//
//            break;
//
//        }
//        System.out.println("Count value is " +count);
//        count++;
//
//        count =6;
//        do {
//            System.out.println("Count value was " + count);
//            count++;
//            if (count>100) {
//                break;
//            }
//        } while (count!=6);

        int totalNumber =0;
        int number =4;
        int finishNumber =20;

        while (number <= finishNumber) {
            number++;
            if (!isEvenNumber(number)) {
                continue;
            }
            totalNumber++;
            System.out.println("Even number "+ number);
            if (totalNumber==5) {
                break;
            }
        }
        System.out.println("Total number of even numbers = "+ totalNumber);


    }

        public static boolean isEvenNumber (int number)
        {
            return (number%2==0);

        }
    }


