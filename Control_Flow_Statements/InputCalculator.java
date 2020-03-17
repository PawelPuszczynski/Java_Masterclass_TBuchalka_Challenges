package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int number;
        int sum = 0;
        int count = 0;
        while (true) {
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt) {

                number = scanner.nextInt();
                count += 1;
                sum += number;

            } else {
                break;
            }
            scanner.nextLine();
        }
        long average = Math.round((double) sum / count);
        System.out.println("SUM = " + sum + " AVG = " + average);
        scanner.close();
    }
}
