package com.company;


import java.util.Scanner;

public class X {
    private int x;

    public X() {
        System.out.println("Enter an integer: \n");
        Scanner x = new Scanner(System.in);
        this.x = x.nextInt();
    }

    public void x  () {

        for (int x = 1; x <= 12 ; x++) {
            System.out.print(( this.x * x) + " ");
        }
    }
}
package com.company;

public class Main {

    public static void main(String[] args) {
    X x = new X();
    x.x();
    }
}
