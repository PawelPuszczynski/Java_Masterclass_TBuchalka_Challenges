package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number;
        int maxNumber=0;
        int minNumber=0;
        boolean first = true; // a flag to indicate 1st intput

        while(true)
        {
            System.out.println("Enter number :");
            boolean hasInt = scanner.hasNextInt();
            if(hasInt) {
                number = scanner.nextInt();
                if (first){     // allows to set min and max = number
                    first=false;// first is true only once - while 1st Num is input
                    maxNumber=number;
                    minNumber=number;
                }

                if (number>maxNumber)
                    maxNumber=number;

                if (number<minNumber)
                    minNumber=number;
            }
            else {

                break;
            }
            scanner.nextLine();
        }


        System.out.println("Min = "+ minNumber+ " Max = " + maxNumber);

        scanner.close();
    }
}
