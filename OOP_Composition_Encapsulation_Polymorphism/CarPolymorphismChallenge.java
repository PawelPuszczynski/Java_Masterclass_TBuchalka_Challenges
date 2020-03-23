package com.company;

import java.util.Scanner;

class Car {
    private String name;
    private int cylinders;
    private boolean engine;
    private int wheels;
    private int speed;


    // CONSTRUCTOR*************************************
    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.engine = true;
        this.wheels = 4;
        this.speed =0;

    }
    // METHODS*************************************************
    public String  startEngine () {
        return " The engine has been started";
    }

    public int accelerate (int rateOfAcceleration) {
        System.out.println("Initial speed :" + speed);
        System.out.println("The car accelerates by :"+ rateOfAcceleration + " km/h" );
        speed+=rateOfAcceleration;
        System.out.println("Current speed = " + speed);
        return speed;
    }
    public int brake (int rateOfBraking) {
        System.out.println("Initial speed :" + speed);
        System.out.println("The car brakes by :"+ rateOfBraking + " km/h" );
        speed-=rateOfBraking;
        System.out.println("Current speed = " + speed);
        return speed;
    }



    // GETTERS ***********************************************
    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public int getSpeed() {
        return speed;
    }
}

//CLASSES FOR VEHICLES **********************************

class AlfaRomeo extends Car {
    public AlfaRomeo() {                        // constructor
        super("Alfa Romeo", 4);     // initializing super-class (Car)
    }

    @Override
    public int accelerate(int rateOfAcceleration) {
        System.out.println("Rate of acceleration is ="+ rateOfAcceleration+" * "+getCylinders());
        return super.accelerate(rateOfAcceleration*getCylinders());


    }

    @Override
    public int brake(int rateOfBraking) {
        System.out.println(" Rate of breaking is "+ rateOfBraking+ " * "+ getCylinders());
        return super.brake(rateOfBraking*getCylinders());
    }
}
class Trabant extends Car {
    public Trabant() {                        // constructor
        super("Trabant", 3);     // initializing super-class (Car)
    }

    @Override
    public int accelerate(int rateOfAcceleration) {
        System.out.println("Rate of acceleration is =" + rateOfAcceleration + " * " + getCylinders());
        return super.accelerate(rateOfAcceleration * getCylinders());


    }

    @Override
    public int brake(int rateOfBraking) {
        System.out.println(" Rate of breaking is " + rateOfBraking + " * " + getCylinders());
        return super.brake(rateOfBraking * getCylinders());
    }
}

class Jeep extends Car {
    public Jeep() {                        // constructor
        super("Jeep", 6);     // initializing super-class (Car)
    }

    @Override
    public int accelerate(int rateOfAcceleration) {
        System.out.println("Rate of acceleration is =" + rateOfAcceleration + " * " + getCylinders());
        return super.accelerate(rateOfAcceleration * getCylinders());


    }

    @Override
    public int brake(int rateOfBraking) {
        System.out.println(" Rate of breaking is " + rateOfBraking + " * " + getCylinders());
        return super.brake(rateOfBraking * getCylinders());
    }
}

    public class Main {

        public static void main(String[] args) {
            System.out.println(">>>>>>>>>>>>>START<<<<<<<<<<<<<<<<");
            Car car = chosenCar();

            System.out.println(" Acceleration and braking test . \n");
//            System.out.println(chosenCar());

            //System.out.println( car.getName() + " acceleration and break test :\n");
            System.out.println("*************************************************");
//
            System.out.println("********************************************\n" +
                                " MARKA : " + car.getName() + "\n # of wheels:"+ car.getWheels()+
                                " \n"+"engine : "+car.isEngine()+ "\n"+
                                "TEST RESULTS: ");
            System.out.println(car.accelerate(10)+"km/h\n"
                                + car.brake(5)+" km/h");


        }


        public static Car chosenCar() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter car #: ");
            int carNumber = scanner.nextInt();
            scanner.nextLine(); // handle enter key
            scanner.close();
            switch (carNumber) {
                case 1:
                    System.out.println("Alfa chosen");
                    return new AlfaRomeo();
                case 2:
                    System.out.println("Trabi chosen");
                    return new Trabant();
                case 3:
                    System.out.println("Jeep chosen");
                    return new Jeep();


                    default:return null;

            }

//            return null;
        }
    }