package com.company;

public class Main {

    public static void main(String[] args) {

        int firstNum=9, secNum=99, thirdNum=19;

        System.out.println(firstNum+" and " + secNum+ " and " + thirdNum+ " share same last digit in 2 cases ="
                            +hasSameLastDigit(firstNum,secNum,thirdNum));
        System.out.println("Number 1 is in range = " + isValid(firstNum)+ "\nNumber 2 is in range = "+isValid(secNum)+
                "\nNumber 3 is in range = "+ isValid(thirdNum));
    }

    public static boolean hasSameLastDigit ( int firstNum, int secNum, int thirdNum)
    {
          if (isValid(firstNum) && isValid(secNum) && isValid(thirdNum))
              return (firstNum%10==secNum%10 || firstNum%10  == thirdNum%10 || secNum%10 == thirdNum%10);
          else return false;


    }
        public static boolean isValid (int number)
        {
            if (number<10 || number>1000)
                return false;
            else return true;

        }
}
