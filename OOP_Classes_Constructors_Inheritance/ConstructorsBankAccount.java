package com.company;

public class BankAccount {

    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private int phoneNumber;

// GETTERS*(*************************************
    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getEmail() {
        return this.email;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    //    Setters ****************
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //    deposit
    public void deposit(double depositAmount) {
        System.out.println("Account balance before deposit = " + getBalance());
        if (depositAmount > 0)
            setBalance(balance + depositAmount);
        System.out.println("Account balance after deposit = " + getBalance());
    }

    public void withdrawal(double withdrawalAmount) {
        System.out.println("Account balance before withdrawal = " + getBalance());
        if (withdrawalAmount <= getBalance()) {
            setBalance(balance - withdrawalAmount);
            System.out.println("Account balance after withdrawal = " + getBalance());
        } else {
            System.out.println("Insufficient funds");
        }
    }
}