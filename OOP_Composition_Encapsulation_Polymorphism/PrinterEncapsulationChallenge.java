package com.company;

import javax.crypto.spec.PSource;

public class Printer {

    private int tonerLevel;
    private int numberOfPages;
    private boolean isDuplex;

    public void fillToner(int cartridgeVolume) {
        isPrinterDuplex();
        System.out.println("Initial toner level = " + getTonerLevel());
        if (tonerLevel + cartridgeVolume > 100) {
            this.tonerLevel = 100;
        } else {
            this.tonerLevel += cartridgeVolume;
        }
        System.out.println("Toner level after filling up = "+ getTonerLevel());
    }

    public void printPage () {
        isPrinterDuplex();
        System.out.println("Initial number of pages printed = "+ getNumberOfPages());
        numberOfPages++;
        System.out.println("Number of pages printed = "+ getNumberOfPages());
    }

    public String  isPrinterDuplex () {
        return (isDuplex)? "The printer is of duplex type.": "The printer is NOT of duplex type.";
        }


    public Printer(int tonerLevel, int numberOfPages, boolean isDuplex) {
        if (tonerLevel<0 || tonerLevel>100) {
            this.tonerLevel = 100;
        }
        this.tonerLevel = tonerLevel;
        this.numberOfPages = numberOfPages;
        this.isDuplex = isDuplex;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public boolean isDuplex() {
        return isDuplex;
    }
}
package com.company;

public class Main {

    public static void main(String[] args) {
	Printer printer = new Printer(60, 40, true);

	printer.printPage();
	printer.fillToner(20);
    }
}
