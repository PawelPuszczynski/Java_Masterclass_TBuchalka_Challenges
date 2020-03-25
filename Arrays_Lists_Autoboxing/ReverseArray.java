package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    int [] array = {1, 2, 3, 4, 5,78,98,990};
reverse(array);
//    for (int i = 0; i < array.length; i++) {
//        System.out.println(" \nOriginal array. Position # "+ i + " is integer: "+ array[i]);
//    }
//        System.out.println("*************************************************");
//    reverse(array);
//    for (int i = 0; i < array.length; i++) {
//            System.out.println("\nReversed array. Position # "+ i + " is integer: "+ array[i]);
//        }

    }

    public static void reverse(int[] array) {
        int[] reversedArray = new int[array.length];
        for(int i = array.length -1; i >= 0; i--) {
            int newPos = (array.length - 1) - i;
            reversedArray[newPos] = array[i];
            System.out.println("reversed "+newPos+" = "+ reversedArray[newPos]);
        }
        System.out.println("Reversed array: " +
                Arrays.toString(reversedArray));
    }

    //    public static void reverse (int [] array) {
//        for (int i = 0; i < array.length; i++) {
//            int temp = array [i];
//            array[i] = array[array.length - 1 - i];
//            array[array.length - 1 - i] = temp;
//            if (i == array.length - 1 - i || i > (array.length - 1) / 2) {
//                break;
//            }

        }
//    }
//}
