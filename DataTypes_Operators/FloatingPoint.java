package com.company;

public class Main {

    public static void main(String[] args) {

        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float Minimum Value = " + myMinFloatValue);
        System.out.println("Float Maximum Value = " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double Minimum Value = " + myMinDoubleValue);
        System.out.println("Double Maximum Value = " + myMaxDoubleValue);

        int myIntValue = 5 / 3;
        float myFloatValue = 5f /3f;
        double myDoubleValue = 5.00 /3.00;
        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue = " + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);

        // Challenge Floating Point
        double Pounds = 200d;

        double PoundToKiloRatio = 0.45359237d;

        double Kilos = Pounds*PoundToKiloRatio;
        System.out.println(Pounds +" pounds is equal to "+Kilos+" kilograms.");

        double pi = 3.1415927d;
        double anotherNumber = 3_000_000.4_567_890d ;
        System.out.println(pi);
        System.out.println(anotherNumber);


    }
}
