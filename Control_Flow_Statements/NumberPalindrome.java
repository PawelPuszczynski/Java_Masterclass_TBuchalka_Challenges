package com.company;

public class Main {

    public static void main(String[] args) {
        int number = 12321;
        System.out.println("Number "+ number+ " is palindrome = " + isPalindrome(number));

    }

    public static boolean isPalindrome (int number)
    {
        if (number<0)
            number=-number;

        int reverse = 0;
        int originalNumber = number;

        while (number>0) {

            int lastDigit = number % 10;
//            System.out.println(lastDigit);
            reverse = reverse * 10;
            reverse +=lastDigit;
//            System.out.println(reverse);
            number /= 10;
        }
        return (reverse == originalNumber);
    }
}
