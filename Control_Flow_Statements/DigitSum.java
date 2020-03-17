package com.company;

public class Main {

    public static void main(String[] args) {


        int number =32123;
        int number1 =12334;
        int number2 = 4;
        System.out.println("Sum of digits in " + number+ " = "+sumDigits(number));
        System.out.println("Sum of digits in " + number+ " = "+sumDigits(number1));
        System.out.println("Sum of digits in " + number+ " = "+sumDigits(number2));
    }
    public static int sumDigits(int number) {
        if (number < 10)
            return -1;
        int sum = 0;

        do {
            int digit = number % 10;
            sum += digit;
            number = (int) number / 10;
        } while (number > 0);

        return sum;
    }
}

