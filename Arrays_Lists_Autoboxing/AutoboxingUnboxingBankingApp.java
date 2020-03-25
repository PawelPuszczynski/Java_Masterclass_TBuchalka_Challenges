package com.company;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String nameOfBank;
    private ArrayList<Branch> listOfBranches;
//CONSTRUCTORS******************************************
    public Bank() {
//        this.nameOfBank = nameOfBank;
//        this.listOfBranches = listOfBranches;
    }

    public Bank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
        this.listOfBranches = new ArrayList<>();
    }
//METHODS**************************************************
    public boolean addNewBranch(String newNameOfBranch) {
        if (findBranch(newNameOfBranch) >= 0) {
            System.out.println(" This branch already exists.");
            return false;
        } else {
            listOfBranches.add(Branch.createBranch(newNameOfBranch));
            return true;
        }
    }

    public int findBranch(String nameOfBranch) {
        for (int i = 0; i < listOfBranches.size(); i++) {
            if (listOfBranches.get(i).getNameOfBranch().equals(nameOfBranch)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewCustomer(String newNameOfCustomer, String nameOfBranch) {
        return listOfBranches.get(findBranch(nameOfBranch)).addNewCustomer(newNameOfCustomer);
    }

    public void addInitialTransaction(String branchName, String newNameOfCustomer, Double transAmount) {
        listOfBranches.get(findBranch(branchName)).addNewTransaction(branchName, newNameOfCustomer, transAmount);
    }

    private int findCustomer(String branchName, String nameOfCustomer) {
        return listOfBranches.get(findBranch(branchName)).findCustomer(nameOfCustomer);
    }

    public boolean addNewTransaction(String branchName, String newNameOfCustomer, Double transAmount) {
        return listOfBranches.get(findBranch(branchName)).addNewTransaction(newNameOfCustomer, transAmount)/*listOfCustomers.get(findCustomer(branchName,newNameOfCustomer))
                .getListOfTrans().add(transAmount)*/;
    }

    public boolean showListOfCustomers(String nameOfBranch) {
        if (listOfBranches.get(findBranch(nameOfBranch)).listOfCustomers.size() > 0) {

            return listOfBranches.get(findBranch(nameOfBranch)).showListOfCustomers(nameOfBranch);
        } else {
            return false;
        }
    }

    public boolean showListOfTransactions(String nameOfBranch, String newNameOfCustomer) {
        /*if ((showListOfCustomers(nameOfBranch) *//*&& listOfBranches.get(findBranch(nameOfBranch)).
                listOfCustomers.get(findCustomer(nameOfBranch, newNameOfCustomer)).
                showListOfTransactions(newNameOfCustomer))))*/
        if (findBranch(nameOfBranch)>=0 && findCustomer(nameOfBranch,newNameOfCustomer)>=0){
            return listOfBranches.get(findBranch(nameOfBranch)).listOfCustomers
                    .get(findCustomer(nameOfBranch, newNameOfCustomer))
                    .showListOfTransactions(newNameOfCustomer);
        } else {
            return false;
        }
    }
}
package com.company;

import java.util.ArrayList;

public class Branch extends Bank {
    private String nameOfBranch;
    public ArrayList<Customer> listOfCustomers;

//CONSTRUCTOR*************************************************
    public Branch(String nameOfBranch) {
        this.listOfCustomers = new ArrayList<Customer>();
        this.nameOfBranch = nameOfBranch;
    }
//GETTERS****************************************************
    public String getNameOfBranch() {
        return nameOfBranch;
    }

    public ArrayList<Customer> getListOfCustomers() {
        return listOfCustomers;
    }
//METHODS**************************************************
    public static Branch createBranch(String nameOfBranch) {
        return new Branch(nameOfBranch);
    }

    public boolean addNewCustomer(String newNameOfCustomer) {
        if (findCustomer(newNameOfCustomer) >= 0) {
            System.out.println(" This customer already exists.");
            return false;
        } else {
            listOfCustomers.add(Customer.createCustomer(newNameOfCustomer));
            return true;
        }
    }

    public int findCustomer(String nameOfCustomer) {
        for (int i = 0; i < listOfCustomers.size(); i++) {
            if (listOfCustomers.get(i).getName().equals(nameOfCustomer)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewTransaction(String nameOfCustomer, Double transAmount) {
        if (findCustomer(nameOfCustomer) >= 0) {
            listOfCustomers.get(findCustomer(nameOfCustomer)).getListOfTrans().add(transAmount);
            return true;
        } else {
            System.out.println("No such customer.");
            return false;

        }
    }

    @Override
    public boolean addNewTransaction(String branchName, String newNameOfCustomer, Double transAmount) {
        listOfCustomers.get(findCustomer(newNameOfCustomer)).getListOfTrans().add(transAmount);
        return true;
    }

    @Override
    public boolean showListOfCustomers(String nameOfBranch) {
        for (int i = 0; i < listOfCustomers.size(); i++) {
            System.out.println(nameOfBranch + " branch. List of customers : \n");
            System.out.println((i + 1) + ". " + listOfCustomers.get(i).getName() + " \n");
        }
        return true ;
    }

    @Override
    public boolean showListOfTransactions(String nameOfBranch, String newNameOfCustomer) {
        if (findCustomer(newNameOfCustomer) > 0) {
            return listOfCustomers.get(findCustomer(newNameOfCustomer)).showListOfTransactions(newNameOfCustomer);
        } else {
            return false;
        }
    }
}

package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> ListOfTrans;
    private double initTransAmount;
// CONSTRUCTOR*****************************************
    public Customer(String name) {
        this.name = name;
        this.initTransAmount = initTransAmount;
        this.ListOfTrans = new ArrayList<Double>();
    }

//    public Customer() {
//        this.name =name;
//
//    }

//GETTERS******************************************
    public String getName() {
        return name;
    }

    public ArrayList<Double> getListOfTrans() {
        return ListOfTrans;
    }
//METHODS********************************************
    public static Customer createCustomer (String name) {
        return new Customer(name);
    }
    public boolean showListOfTransactions (String nameOfCustomer) {
        System.out.println(" Customer: " + nameOfCustomer +" List of transactions : \n");
            for (int i = 0; i <ListOfTrans.size(); i++) {
                  System.out.println((i + 1) + ". " + ListOfTrans.get(i).doubleValue() + ", \n");
        }
        return true /*super.showListOfCustomers(nameOfBranch)*/;
    }

}


package com.company;

import java.util.Scanner;

public class Main {
private static Scanner scanner = new Scanner(System.in);
private static Bank bank = new Bank("International Bank of Java");
    public static void main(String[] args) {
	// MAIN MENU of banking system *******************************

        boolean quit = false;
        printMenu ();
        while (!quit) {
            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 0 :
                    printMenu();
                    break;
                case 1:
                    addNewBranch ();
                    break;
                case 2:
                    addNewCustAndInitTrans ();
                    break;
                case 3 :
                    addTransExistingCust ();
                    break;
                case 4:
                    showListOfCustBranch ();
                    break;
                case 5:
                    showListOfTrans ();
                    break;
                case 6 :
                    quit =true;
                    break;

            }
        }
    }
// METHODS********************************************
  private static void printMenu () {
      System.out.println("\n Banking system. Main Menu.");
      System.out.println(" 0 - print Main Menu.\n"+
                            " 1 - add a new branch\n"+
                            " 2 - add new customer and initial transaction amount\n"+
                            " 3 - add transaction amount for existing customer \n"+
                            " 4 - show customers list of a branch\n"+
                            " 5 - show list of transactions of a particular customer\n"+
                            " 6 - quit");
      System.out.println("Enter your choice : ");


  }
  private static void addNewBranch () {
          System.out.println("Enter new branch name : ");
          String branchName = scanner.nextLine();
//          Branch newBranch = Branch.createBranch(branchName);
          if (bank.addNewBranch (branchName)) {
              System.out.println("New branch: "+ branchName + " successfully added.");
          } else {
              System.out.println(" Cannot add : "+ branchName+ " - already exists.");
          }
  }

    private static void addNewCustAndInitTrans () {
        System.out.println("Enter branch name : ");
        String branchName = scanner.nextLine();
        System.out.println("Enter customers name : ");
        String customersName = scanner.nextLine();
        System.out.println("Enter initial transaction amount : ");
        double transInAmount = scanner.nextDouble();

//        Customer newCustomer = Customer.createCustomer(customersName);

        if (bank.addNewCustomer(customersName,branchName)) {

          //************************************* adding initial transaction
            bank.addInitialTransaction(branchName,customersName, transInAmount);
            System.out.println("New customer: "+ customersName + " successfully added in branch:"+
                    branchName +", with initial transaction of : "+transInAmount);
        } else {
            System.out.println(" Cannot add : "+ customersName+ " - this customer already exists.");
        }
    }
    private static void addTransExistingCust () {
        System.out.println("Enter branch name : ");
        String branchName = scanner.nextLine();
        System.out.println("Enter customers name : ");
        String customersName = scanner.nextLine();
        System.out.println("Enter transaction amount : ");
        double transAmount = scanner.nextDouble();

        if (bank.addNewTransaction(branchName,customersName,transAmount)) {
            System.out.println("A transaction in amount of:" + transAmount + " has been successfully recorded.");
        } else {
            System.out.println(" Cannot add transaction customer : "+ customersName+ " - does not exist.");
        }

        }
        private static void showListOfCustBranch () {
            System.out.println("Enter branch name : ");
            String branchName = scanner.nextLine();
        if (!bank.showListOfCustomers(branchName)) {
            System.out.println("No customers registered in this branch.");
        }

        }
        private static void showListOfTrans () {
            System.out.println("Enter branch name : ");
            String branchName = scanner.nextLine();
            System.out.println("Enter customers name : ");
            String customersName = scanner.nextLine();
            if (!(bank.showListOfTransactions(branchName,customersName))) {
                System.out.println(" No "+ customersName + " customer in "+ branchName +" branch." +
                        "Enter correct data.");
            }
        }

}








