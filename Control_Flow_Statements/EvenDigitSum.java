package com.company;

public class Main {

    public static void main(String[] args) {
        int number = -22;
        System.out.println("Sum of even digits of " + number+ " = "+getEvenDigitSum(number));
    }

    public static int getEvenDigitSum (int number)
    {
        if (number<0)
            return -1;
        int lastDigit =0;
        int sum =0;

        while (number>0) {
            lastDigit=number%10;
            if (lastDigit%2==0)
            sum+=lastDigit;
            number/=10;
        }
        return sum;
    }
}
