package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        int counter = 0;
        int sum=0 ;

        while (counter<10)
        {
            int order = counter+1;
            System.out.println("Enter number #"+order+ " : ");
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt)
            {
                int numberInput = scanner.nextInt();
                sum += numberInput;
                counter++;
            }
            else {
                System.out.println("Invalid Number");
            }
            scanner.nextLine();
        }

        System.out.println(sum);
        scanner.close();

    }
}
