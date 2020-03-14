package com.company;

public class Main {

    public static void main(String[] args) {

        double myFirstVariable = 20.00d ;
        double mySecondVariable = 80.00d ;
        double myResult = (myFirstVariable + mySecondVariable) * 100.00d ;
        System.out.println("myResult = " + myResult);
        double myRemainder = myResult % 40.00d;
        System.out.println(" myRemainder = " + myRemainder);
        boolean isMyBoolean = (myRemainder == 0.00) ? true : false ;
        System.out.println("isMyBoolean = " + isMyBoolean);
        if (!isMyBoolean) {
            System.out.println(" Got some remainder.");
        }



    }
}
