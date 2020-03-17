package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600));// method calling
        System.out.println(getDaysInMonth(2,2020));
    }
    public static boolean isLeapYear (int year)
    {
        if (year<1 || year >9999)
            return false;
            return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

    }

    public static int getDaysInMonth (int month, int year)

    {
        if((month<1 || month>12)||(year<1 || year >9999))
            return -1;
            else if (month==2)
                return isLeapYear(year) ? 29:28;
            else {
                switch (month) {
                    case 4: case 6: case 9 : case 11 :
                        return 30;
                    default:
                        return 31;
                }
            }
        }
    }

