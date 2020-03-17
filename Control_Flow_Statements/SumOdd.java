package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Result = " + sumOdd(1,20));
    }

    public static boolean isOdd (int number)
    {
        if ((number <=0)||(number%2==0))
            return false;
        else return true;
    }

    public static int sumOdd (int start, int end)
    {
        int sum = 0;
        if (end < start || start <= 0)
            return -1;

            for (int i=start; i<=end; i++) {
                if (isOdd(i))
//                    System.out.println(i);
                    sum += i;
                System.out.println(i);
            }

            return sum;

    }
}
