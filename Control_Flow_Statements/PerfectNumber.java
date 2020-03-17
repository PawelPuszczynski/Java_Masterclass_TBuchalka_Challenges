package com.company;

public class Main {

    public static void main(String[] args) {
        int number = 6;
        System.out.println("Number " + number+ " is perfect = " + isPerfectNumber(number));
    }

    public static boolean isPerfectNumber (int number)
    {
        if (number<1)
            return false;
        int sumOfDivisors = 0;
        int i;
        for (i=number-1; i>=1; i--) {
            if (number % i == 0)
                sumOfDivisors += i;
        }

        return (sumOfDivisors==number);
    }
}
