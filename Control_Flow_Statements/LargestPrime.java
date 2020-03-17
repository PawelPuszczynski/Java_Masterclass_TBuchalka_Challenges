package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(2));
    }

    public static int getLargestPrime(int number) {
        if (number <= 1)
            return -1;

        int factor = number;
        int factorToTest = 0;

        while (factor > 0) {
            if (number % factor == 0) {
                factorToTest = factor;
                int primeFactor = factorToTest - 1;

                while (primeFactor > 1) {
                    if (factorToTest % primeFactor == 0)
                        break;
                    primeFactor--;
                }
                if (primeFactor == 1)
                    break;
            }
            factor--;
        }
        return factorToTest;
    }
}
