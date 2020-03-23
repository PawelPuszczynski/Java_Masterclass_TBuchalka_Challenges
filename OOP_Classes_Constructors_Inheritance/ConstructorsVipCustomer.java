package com.company;

public class VipCustomer {


    private String name;
    private double creditLimit;
    private String emailAddress;


    public VipCustomer() {
        this("Default name", 100, "m@mem");
        System.out.println("Empty constructor called");
    }

    public VipCustomer(String name, double creditLimit) {
        this(name, creditLimit, "m@mememe");
        System.out.println(("2nd constructor called"));
    }


    public VipCustomer (String name, double creditLimit, String emailAddress) {
        System.out.println("VipCustomer consturctor with parameters called");
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }



    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}