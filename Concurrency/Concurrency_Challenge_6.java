package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge7 {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("12345-678", 500.00);
        BankAccount account2 = new BankAccount("98765-432", 1000.00);

        new Thread(new Transfer(account1, account2, 10.00), "Transfer1").start();
        new Thread(new Transfer(account2, account1, 55.88), "Transfer2").start();
    }
}

class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock();

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        try {


            if (lock.tryLock()) {
                try {
                    // Simulate database access
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                balance -= amount;
                System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                return true;
            }
        }finally {
            lock.unlock();
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (lock.tryLock()) {
            try {
                // Simulate database access
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
            }
            balance += amount;
            System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            }
            else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account busy. Refunding money\n",
                        Thread.currentThread().getName());
                deposit(amount);
            }
        }

        return false;
    }
}

class Transfer implements Runnable {
    private BankAccount sourceAccount, destinationAccount;
    private double amount;

    Transfer(BankAccount sourceAccount, BankAccount destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public void run() {
        while (!sourceAccount.transfer(destinationAccount, amount))
            continue;
        System.out.printf("%s completed\n", Thread.currentThread().getName());
    }


}


package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private Lock lock;
    private Lock lock1;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
        this.lock1 = new ReentrantLock();
    }
//  1 WAY OF SYNCHRONIZATION: WHOLE METHOD IS SYNCHRONIZED
//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }

    //2ND WAY : CODE WITHIN A METH IS SYNCHRONIZED if not all the code of a Meth is CRITICAL SECTION
    public void deposit(double amount) {

        lock.lock();

            boolean status = false;

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance +=amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }

        } catch (InterruptedException e) {
            // do something
        }
        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {

        boolean status = false;
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -=amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Transaction status = " + status);
    }
    public String getAccountNumber () {
        return accountNumber;
    }


    public void printAccountNumber () {

        System.out.println("Account number = " + accountNumber);
    }


}
package com.company;

public class Main {

    public static void main(String[] args) {

        final BankAccount account = new BankAccount("12345-678", 1000.00);

        //  TWO WAYS OF CREATING THREADS
        //1st WAY - INNER CLASS THREAD1 AND THREAD2

//        Thread trThread1 = new Thread() {
//            public void run () {
//                account.deposit(300.00);
//                account.withdraw(50.00);
//            }
//        };
//
//        Thread trThread2 = new Thread() {
//            public void run () {
//                account.deposit(203.75);
//                account.withdraw(100);
//            }
//        };

        // 2nd WAY : CREATE THREADS USING RUNNABLE INTERFACE , HERE: ANONYMOUS RUNNABLE INSTANCES

        Thread trThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300);
                account.withdraw(50);
            }
        });
        Thread trThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100);

            }
        });
        trThread1.start();
        trThread2.start();

    }
}
