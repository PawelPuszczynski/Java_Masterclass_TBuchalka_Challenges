package com.company;

public class Main {

    public static void main(String[] args) {

        int number = 99;
        System.out.println("Sum of first and last digit of "+number+" = " + sumFirstAndLastDigit(number));
    }

    public static int sumFirstAndLastDigit (int number)
    {
        if (number < 0)
            return -1;

        int firstDigit =0;
        int lastDigit= number%10;

        while (number>0)
        {
            if (number<10) {
                firstDigit = number;}
            number /=10;
        }
        return (lastDigit+firstDigit);
    }

}
