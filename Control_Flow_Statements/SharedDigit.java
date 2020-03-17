package com.company;

public class Main {

    public static void main(String[] args) {

        int firstNumber =15;
        int secondNumber =55;
        System.out.println("For "+firstNumber+" and "+secondNumber+" there is share digit = "+hasSharedDigit(firstNumber,secondNumber));
    }

    public static boolean hasSharedDigit ( int firstNumber, int secondNumber) {
        if (firstNumber < 10 || firstNumber > 99 || secondNumber < 10 || secondNumber > 99)
            return false;

        int lDigitFirstN = firstNumber % 10;
        int lDigitSecN = secondNumber % 10;

        int fDigitFirstN = firstNumber/10 ;
        int fDigitSecN = secondNumber/10 ;

        return  (lDigitFirstN == lDigitSecN)||(fDigitFirstN == fDigitSecN)||
                    (fDigitFirstN==lDigitSecN) || (fDigitSecN == lDigitFirstN);


    }




}
