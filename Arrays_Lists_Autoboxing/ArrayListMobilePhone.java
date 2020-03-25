package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contactsArrayList = new ArrayList<>();


    public void printContacts() {
        System.out.println("Total number of contacts: " + contactsArrayList.size() + " \n");
        for (int i = 0; i < contactsArrayList.size(); i++) {

            System.out.println((i + 1) + "." + " Name: " + contactsArrayList.get(i).getName() +
                    " phone No: " + contactsArrayList.get(i).getPhoneNo() + "\n");
        }
    }

    public void addContact(String name, String phoneNo) {


        Contact contact = new Contact(name, phoneNo);
         if (contactsArrayList.contains(findContact(contact.getName()))){
            System.out.println(" Contact with this name already exists.");
        } else {
            contactsArrayList.add(contact);
             System.out.println("Contact: " + contact.getName() + " has been successfully added");
            return;
        }
    }

    public void removeContact(String nameToRemove) {
        for (int i = 0; i < contactsArrayList.size(); i++) {
            if ((contactsArrayList.get(i)).getName().equals(nameToRemove)) {
                contactsArrayList.remove(i);
                System.out.println("Contact " + nameToRemove + " has been successfully removed.");
                break;
            }
            System.out.println(" No such name on Contact List.");
        }
    }

    public void updateContact(Contact contact, int option, String change) {

         if (option == 1) {
             if ((findContact(change)!=null &&
                     findContact(change).getName().equals(change)) &&
                     contact != findContact(change)) {
                 System.out.println(" Contact with this name already exists.");
             } else {
                 contact.setName(change);
                 System.out.println("Contact name has been successfully updated.");
             }
         }
            else {
                contact.setPhoneNo(change);
            System.out.println("Contact phone number has been successfully updated.");
        }


    }

    public Contact findContact(String nameSearched) {
        for (int i = 0; i < contactsArrayList.size(); i++) {
            if ((contactsArrayList.get(i)).getName().equals(nameSearched)) {
                return contactsArrayList.get(i);
            }
        }
        return null;
    }
}

package com.company;

public class Contact {
    private String name;
    private String phoneNo;

    public Contact(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        // Main Menu print-out. Users choice input
        boolean quit = false;
        int choice;
        printMenu();
        while (!quit) {
            System.out.println(" Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    printMenu();
                    break;
                case 2:
                    printContacts();
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    updateContact();
                    break;
                case 6:
                    findContact();
                    break;
                case 7:
                    quit = true;
                    break;

            }
        }
    }

    // Main Menu print Method***************************************
    private static void printMenu() {
        System.out.println("\n Main Menu. Press :");
        System.out.println("\t 1 - to print the Main Menu.");
        System.out.println("\t 2 - to print the List of Contacts");
        System.out.println("\t 3 - to add new contact");
        System.out.println("\t 4 - to remove existing contact");
        System.out.println("\t 5 - to update existing contact");
        System.out.println("\t 6 - to find existing contact");
        System.out.println("\t 7 - to quit");
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void addContact() {
        System.out.println("Enter name: \n");
        String name = scanner.nextLine();

        System.out.println("Enter phone number: \n");
        String phoneNo = scanner.nextLine();

        mobilePhone.addContact(name, phoneNo);
    }

    private static void removeContact() {
        System.out.println("Enter name of the contact to remove: ");
        String nameToRemove = scanner.nextLine();
        mobilePhone.removeContact(nameToRemove);
    }

    private static void updateContact() {
        System.out.println("Enter name of the contact to update: ");
        String nameToUpdate = scanner.nextLine();
        Contact tempContact = mobilePhone.findContact(nameToUpdate);
        if (tempContact == null) {
            System.out.println(" No such name on Contact List.");

        } else {
            System.out.println("To change name press 1.\n");
            System.out.println("To change phone number press 0.\n");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Enter new name: \n");
                String newName = scanner.nextLine();
                mobilePhone.updateContact(tempContact, 1, newName);
            } else {
                System.out.println("Enter new phone number: \n");
                String newPhoneNo = scanner.nextLine();
                mobilePhone.updateContact(tempContact, 2, newPhoneNo);

            }
        }
    }

        private static void findContact() {
            System.out.println("Enter name of the contact to find: ");

            Contact tempContact = mobilePhone.findContact(scanner.nextLine());
            if (tempContact == null) {
                System.out.println(" No such name on Contact List.");
            } else {
                System.out.println(" Contact name : " + tempContact.getName() +
                        "\n Contact phone number: " + tempContact.getPhoneNo());
            }
        }
    }
