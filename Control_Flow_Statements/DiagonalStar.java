package com.company;

public class Main {

    public static void main(String[] args) {

        printSquareStar(2);
    }
    public static void printSquareStar (int number)
    {
        if (number<5)
        {
            System.out.println("Invalid Value");
        }
        else {
            int r;
            for (r = 1; r <= number; r++) {
                int c;
                for (c = 1; c <= number; c++) {
                    if (r == 1 || r == number || c == 1 || r == c || c == number - r + 1 || c == number)
                        System.out.print("*");
                    else System.out.print(" ");
                    if (c == number) System.out.println("");
                }
            }
        }
    }
}
