package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(81,153));

    }
    public static int getGreatestCommonDivisor ( int first, int second) {
        if (first < 10 || second < 10)
            return -1;
        if (first == second)
            return first;
        int minimum, maximum;
        if (first < second) {
            minimum = first;
            maximum = second;
        } else {
            minimum = second;
            maximum = first;
        }
        int currentDivisor = minimum;
        while (currentDivisor >= 1) {
            if (maximum % minimum == 0)
                return minimum;
            else if (maximum % currentDivisor == 0 && minimum % currentDivisor == 0)
               break;
            currentDivisor--;
        }

        return currentDivisor;


    }

}




