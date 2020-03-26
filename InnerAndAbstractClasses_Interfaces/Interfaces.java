package com.company;

import java.util.ArrayList;

public interface ISaveable {
    ArrayList<String> arrayListSavedValues  ();
    void populateObjectFields (ArrayList<String> arrayList );
}
package com.company;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class Monster implements ISaveable {
    private String name;
    private int energy;
    private int numberOfHeads;
    private String colorOfWings;

    public Monster(String name, int energy, int numberOfHeads, String colorOfWings) {
        this.name = name;
        this.energy = energy;
        this.numberOfHeads = numberOfHeads;
        this.colorOfWings = colorOfWings;
    }

    @Override
    public ArrayList<String> arrayListSavedValues() {
        ArrayList<String> objectProperties = new ArrayList< >();
        objectProperties.add(this.name);
        String energy = Integer.toString(this.energy);
        objectProperties.add(energy);
        String numberOfHeads = Integer.toString(this.numberOfHeads);
        objectProperties.add(numberOfHeads);
        objectProperties.add(this.colorOfWings);

        return objectProperties;
    }

    @Override
    public void populateObjectFields(ArrayList<String> arrayList) {
        this.name = arrayList.get(0);
        this.energy = Integer.parseInt(arrayList.get(1));
        this.numberOfHeads = Integer.parseInt(arrayList.get(2));
        this.colorOfWings = arrayList.get(3);

    }
    @Override
    public String toString() {
        return "Monster's saved values :"+ arrayListSavedValues().toString();
    }
}
package com.company;

import java.util.ArrayList;

public class Player implements ISaveable{
    private String name;
    private int strength;
    private String weapon;
    private String sex;


    public Player(String name, int strength, String weapon, String sex) {
        this.name = name;
        this.strength = strength;
        this.weapon = weapon;
        this.sex = sex;
    }

    @Override
    public ArrayList<String> arrayListSavedValues() {
        ArrayList<String> objectProperties = new ArrayList< >();
        objectProperties.add(this.name);
        String strength = Integer.toString(this.strength);
        objectProperties.add(strength);
        objectProperties.add(this.weapon);
        objectProperties.add(this.sex);

        return objectProperties;
    }

    @Override
    public void populateObjectFields(ArrayList<String> arrayList) {

        this.name = arrayList.get(0);
        this.strength =Integer.parseInt(arrayList.get(1));
        this.weapon = arrayList.get(2);
        this.sex = arrayList.get(3);

    }

    @Override
    public String toString() {
        return "Player's saved values :"+ arrayListSavedValues().toString();
    }
}
package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ISaveable gameCharacter;
        gameCharacter =new Player("Bill",4,"axe","male");
        System.out.println("Saved object data : " + savingObject(gameCharacter).toString());
        populatingObject(gameCharacter);
        System.out.println(gameCharacter.toString());

        System.out.println("Next Object test***********************************************");

        gameCharacter = new Monster("Sphinx", 1, 3,"red");
        System.out.println("Saved object data : " + savingObject(gameCharacter).toString());
        populatingObject(gameCharacter);
        System.out.println(gameCharacter.toString());

    }

    public static ArrayList<String> savingObject (ISaveable object){
        return  object.arrayListSavedValues();

    }
    public static void populatingObject (ISaveable object) {
        object.populateObjectFields(readValues());

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
