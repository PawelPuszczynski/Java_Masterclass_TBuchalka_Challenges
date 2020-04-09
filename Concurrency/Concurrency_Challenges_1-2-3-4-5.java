

package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount extends ReentrantLock {
    private double balance;
    private String accountNumber;
    private ReentrantLock reentrantLock;

    public  BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.reentrantLock = new ReentrantLock();
    }

    public  void deposit(double amount) throws InterruptedException {
        try {
            if(reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    System.out.println(" acc balance:" + balance);
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void withdraw(double amount) throws InterruptedException {

        try {
            if (reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    System.out.println(" acc balance:" + balance);

                } finally {
                    reentrantLock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public String getAccountNumber () {
        return accountNumber;
    }

    public void printAccountNumber (){
        System.out.println("Account number = " + accountNumber);
    }

    public double  getBalance() {
        return balance;
    }
}
package com.company;

public class newThread1 extends Thread {

}

package com.company;

public class Main {

    public BankAccount account = new BankAccount("12345-678", 1000.00);

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345-678", 1000.00);

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    account.deposit(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    account.withdraw(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }) {

        }.start();
        new Thread(new Runnable() {
//            public BankAccount account;

            @Override
            public void run() {
                try {
                    account.deposit(203.75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    account.withdraw(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
	
    }
}


