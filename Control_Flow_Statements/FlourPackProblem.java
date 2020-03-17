package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(canPack(2,10,21));
    }
    public static boolean canPack (int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0)
            return false;

        else if (bigCount * 5 > goal)
            return goal - (5 * (goal/5)) <= smallCount;

        else return goal % (bigCount * 5) <= smallCount && bigCount * 5 + smallCount >= goal;
    }
    }

