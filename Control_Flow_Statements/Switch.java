package com.company;

public class Main {

    public static void main(String[] args) {
        char switchValue='C';
        switch (switchValue) {
            case 'A':
                System.out.println("Was A");
                break;
            case 'B':
                System.out.println("Was B");
                break;
            case 'C':
                System.out.println("Was C");
                break;
            case 'D':
                System.out.println("Was D");
                break;
            case 'E':
                System.out.println("Was E");
                break;
            default:
                System.out.println("ABCDE not found");
                break;
    }
}
