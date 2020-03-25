package com.company;

import java.util.Scanner;

public class Main {

private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            System.out.println("Enter a number (count) : \r");
            int count = scanner.nextInt();
            scanner.nextLine();

            int [] newArray = readIntegers (count);
            System.out.println("Min Integer = "+ findMin(newArray));

    }

    private static int [] readIntegers(int count) {
        int [] tempArray = new int [count];
        System.out.println("Enter "+ count + " integers");
        for (int i =0; i<tempArray.length; i++) {
            tempArray[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return tempArray;
    }

    private static int findMin(int[] array){
        int minInteger= array[0];
        for (int i = 1; i < array.length; i++) {
            if (array [i]< minInteger) {
                minInteger=array[i];
            }
        }
        return minInteger;
    }

}
