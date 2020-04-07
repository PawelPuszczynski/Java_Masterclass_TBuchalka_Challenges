package com.example.packagechallenge;

public class Series {
    public static int nSum(int n) {

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            int temp = i;
            sum = sum + temp;
        }
        return sum;
    }

    public static int factorial(int n) {
        int product = 1;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            product = product * temp;
        }
        return product;

    }

    public static int fibonacci(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {

                int temp = (n - 1);
                int temp2 = (n - 2);
            return fibonacci(temp)+fibonacci(temp2);
            }
            }
        }



