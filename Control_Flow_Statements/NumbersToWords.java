package com.company;

public class Main {

    public static void main(String[] args) {
        numberToWords(0);
//        System.out.println(getDigitCount(0));
//        System.out.println(reverse(0));
    }

    public static void numberToWords(int number) {

        if (number < 0)
            System.out.println("Invalid Value");

        int originalNumber= number;

        number = reverse(number);

        do {

            int lastDigit =number%10;

            switch (lastDigit) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
            number /= 10;
            } while (number>=1);

        int digitDifference= getDigitCount(originalNumber)-getDigitCount(reverse(originalNumber));

        for (int i = digitDifference ; i > 0; i--)
        { System.out.println("Zero");}

        }

        public static int reverse (int numberRev) {

            int reversedNumber=0;

            while (Math.abs (numberRev)> 0) {
                int lastDigit = numberRev % 10;
                reversedNumber = reversedNumber * 10 + lastDigit;
                numberRev /= 10;
            }
            return reversedNumber;
        }


        public static int getDigitCount(int number)
        {
            if (number<0)
                return -1;
            int digitCount=0;
            do {
                digitCount++;
            number/=10;} while (number> 0);
            return digitCount;
        }

    }
