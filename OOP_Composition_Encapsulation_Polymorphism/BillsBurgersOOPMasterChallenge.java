package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Hamburger {
// FIELDS****************************************
    private String breadType;
    private String meat;
    private double basePrice;
    //    private double totalPrice;
    private Addition addition1;
    private Addition addition2;
    private Addition addition3;
    private Addition addition4;


//CONSTRUCTORS *********************************************************

public Hamburger () {
    this("white", "beef", 2.0);// default parameters for basic burger
}
    public Hamburger(String breadType, String meat, double basePrice) {

        this.breadType = breadType;
        this.meat = meat;
        this.basePrice = basePrice;

        if (addition1==null){
            this.addition1= new Addition();
        } else {
            this.addition1=addition1;
        }
        if (addition2==null){
            this.addition2= new Addition();
        } else {
            this.addition2=addition2;
        }
        if (addition3==null){
            this.addition3= new Addition();
        } else {
            this.addition3=addition3;
        }
        if (addition4==null){
            this.addition4= new Addition();
        } else {
            this.addition4=addition4;
        }

    }



//    METHODS



//    public Addition choiceOfAddition() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Additions available:\n1. carrot\n2. onions\n3. lettuce\n4. tomato\n5. pickles\n" +
//                " 6. bacon") ;
//        System.out.println("Enter addition #: ");
//        int additionNumber = scanner.nextInt();
//        scanner.nextLine(); // handle enter key
//        scanner.close();
//        switch (additionNumber) {
//            case 1:
//                System.out.println("carrot chosen");
//                return new Carrot();
//            case 2:
//                System.out.println("Onions chosen");
//                return new Onions();
//            case 3:
//                System.out.println("Lettuce chosen");
//                return new Lettuce();
//            case 4:
//                System.out.println("Tomato chosen");
//                return new Tomato();
//            case 5:
//                System.out.println("Pickles chosen");
//                return new Pickles();
//            case 6:
//                System.out.println("Bacon chosen");
//                return new Bacon();
//
//
//            default:return null;
//
//        }
//
////            return null;
//    }

    public double priceCalculation () {
//        double totalPriceOfAdditions =0;
//        for (int i=1; i<5; i++){
//           totalPriceOfAdditions += choiceOfAddition().getPriceOfAddition();
//            System.out.println(totalPriceOfAdditions);
//            System.out.println("Addition "+ choiceOfAddition().getNameOfAddition()+
//                    " for "+choiceOfAddition().getPriceOfAddition()+ " USD\n");
//
//        }
        double totalPriceOfAdditions =/*Math.round*/( getAddition1().getPriceOfAddition()+ getAddition2().getPriceOfAddition() +
                getAddition3().getPriceOfAddition() + getAddition4().getPriceOfAddition())/* *100)/100.0)*/;

        System.out.println("Your "+getClass().getSimpleName()+" consists of: \n" +
                "- Bread type: "+ breadType + "\n - Meat: "+ meat +"\n");
        System.out.println(" Subtotal: Base Price = "+ this.basePrice+ " USD\n");
        System.out.println(" Additions:\n");

        System.out.println("1. "+ addition1.getNameOfAddition()+ " price: "+addition1.getPriceOfAddition() +" USD\n");
        System.out.println("2. "+ addition2.getNameOfAddition()+ " price: "+addition2.getPriceOfAddition() +" USD\n");
        System.out.println("3. "+ addition3.getNameOfAddition()+ " price: "+addition3.getPriceOfAddition() +" USD\n");
        System.out.println("4. "+ addition4.getNameOfAddition()+ " price: "+addition4.getPriceOfAddition() +" USD\n");

        System.out.println("Subtotal : Price of Additions = "+totalPriceOfAdditions+ " USD");


        double totalPrice = Math.round((this.basePrice + totalPriceOfAdditions)*100)/100.0;
        System.out.println("Total Price of "+ getClass().getSimpleName() + " = " +totalPrice + " USD");
        System.out.println("*********************************************************************");

        return totalPrice;
    }

//GETTERS*************************************************************

    public String getBreadType() {
        return breadType;
    }

    public String getMeat() {
        return meat;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Addition getAddition1() {

           return addition1;
    }

    public Addition getAddition2() {
        return addition2;
    }

    public Addition getAddition3() {
        return addition3;
    }

    public Addition getAddition4() {


        return addition4;
    }

//    public void setBreadType(String breadType) {
//        this.breadType = breadType;
//    }
//
//    public void setMeat(String meat) {
//        this.meat = meat;
//    }
//
//    public void setBasePrice(double basePrice) {
//        this.basePrice = basePrice;
//    }

    public void setAddition1(Addition addition1) {

        this.addition1 = addition1;
    }

    public void setAddition2(Addition addition2) {
        this.addition2 = addition2;
    }

    public void setAddition3(Addition addition3) {
        this.addition3 = addition3;
    }

    public void setAddition4(Addition addition4) {
        this.addition4 = addition4;
    }
}


package com.company;

public class Addition {
    //FIELDS*************************************
    private String nameOfAddition;
    private double priceOfAddition;

    // CONSTRUCTORS**********************************
    public Addition() {
        this("no addition", 0.0);
    }

    public Addition(String nameOfAddition, double priceOfAddition) {
        this.nameOfAddition = nameOfAddition;
        this.priceOfAddition = priceOfAddition;
    }


    // GETTERS*****************************************************
    public String getNameOfAddition() {
        return nameOfAddition;
    }

    public double getPriceOfAddition() {
        return priceOfAddition;
    }
}
//
//    public void setNameOfAddition(String nameOfAddition) {
//        this.nameOfAddition = nameOfAddition;
//    }
//
//    public void setPriceOfAddition(double priceOfAddition) {
//        this.priceOfAddition = priceOfAddition;
//    }
//}
//    class Carrot extends Addition {
//        public Carrot() {
//            super("carrot",0.1);
//        }
//
//    }
//    class Onions extends Addition {
//        public Onions() {
//            super("onions", 0.2);
//        }
//    }
//    class Lettuce extends Addition {
//        public Lettuce() {
//            super("lettuce", 0.3);
//        }
//    }
//    class Tomato extends Addition {
//                public Tomato() {
//                    super("tomato", 0.4);
//                }
//}
//class Pickles extends Addition {
//    public Pickles() {
//        super("pickles", 0.5);
//    }
//}
//class Bacon extends Addition {
//    public Bacon() {
//        super("bacon", 0.6);
//    }
//}
//
//class Chips extends Addition {
//    public Chips() {
//        super("chips", 0.35);
//    }
//}
//    class Coke extends Addition {
//        public Coke() {
//            super("Coke", 0.45);
//        }
//}
//
//
//
//


package com.company;

public class HealthyBurger extends Hamburger {

    private Addition addition5;
    private Addition addition6;

    // CONSTRUCTORS **********************************************
    public HealthyBurger (){
        this( "beef", 2.5);// default parameters for HealthyBurger
    }

    public HealthyBurger( String meat, double basePrice) {
        super("brown rye", meat, basePrice);
        if (addition5 == null) {
            this.addition5 = new Addition();
        } else {
            this.addition5 = addition5;
        }
        if (addition6 == null) {
            this.addition6 = new Addition();
        } else {
            this.addition6 = addition6;

        }

        //    public HealthyBurger( String meat, double basePrice) {
//
//        super ("brown rye", meat, basePrice);
//
//    }

    }

    //METHODS****************************************

    @Override
    public double priceCalculation() {

        double totalPriceOfAdditions = /*Math.round((*/(getAddition1().getPriceOfAddition()+ getAddition2().getPriceOfAddition() +
                getAddition3().getPriceOfAddition() + getAddition4().getPriceOfAddition()+addition5.getPriceOfAddition()
                +addition6.getPriceOfAddition())/**100)/100.0)*/;

        System.out.println("Your "+getClass().getSimpleName()+" consists of: \n" +
                "- Bread type: "+ getBreadType() + "\n - Meat: "+ getMeat() +"\n");
        System.out.println(" Subtotal: Base Price = "+ getBasePrice() + " USD\n");
        System.out.println(" Additions:\n");

        System.out.println("1. "+ getAddition1().getNameOfAddition()+ " price: "+getAddition1().getPriceOfAddition() +" USD\n");
        System.out.println("2. "+ getAddition2().getNameOfAddition()+ " price: "+getAddition2().getPriceOfAddition() +" USD\n");
        System.out.println("3. "+ getAddition3().getNameOfAddition()+ " price: "+getAddition3().getPriceOfAddition() +" USD\n");
        System.out.println("4. "+ getAddition4().getNameOfAddition()+ " price: "+getAddition4().getPriceOfAddition() +" USD\n");
        System.out.println("5. "+ getAddition5().getNameOfAddition()+ " price: "+getAddition5().getPriceOfAddition() +" USD\n");
        System.out.println("6. "+ getAddition6().getNameOfAddition()+ " price: "+getAddition6().getPriceOfAddition() +" USD\n");

        System.out.println("Subtotal : Price of Additions = "+totalPriceOfAdditions+ " USD");


        double totalPrice = Math.round((getBasePrice() + totalPriceOfAdditions)*100)/100.0;
        System.out.println("Total Price of "+ getClass().getSimpleName() + " = " + totalPrice + " USD");
        System.out.println("*********************************************************************");

        return totalPrice;

    }


    // GETTERS & SETTERS*************************************************

    public Addition getAddition5() {
        return addition5;
    }

    public void setAddition5(Addition addition5) {
        this.addition5 = addition5;
    }

    public Addition getAddition6() {
        return addition6;
    }

    public void setAddition6(Addition addition6) {
        this.addition6 = addition6;
    }
}
package com.company;

public class DeluxeBurger extends Hamburger {
    private Addition coke;
    private Addition chips;


// CONSTRUCTORS**************************************

    public DeluxeBurger (){
        this ("white", "chicken", 3.0, null, null) ;
    }
    public DeluxeBurger(String breadType, String meat, double basePrice, Addition coke , Addition chips) {
        super (breadType, meat, basePrice);// inherited fields
        if (coke == null) {// generic fields - specific for child-class
            this.coke = new Addition("coke", 0.37);
        } else {
            this.coke =  coke;

        }
        if (chips == null) {
            this.chips = new Addition("chips", 0.27);
        } else {
            this.chips = chips;
        }

    }

    //METHODS****************************************************************


    @Override
    public double priceCalculation() {
        double totalPriceOfAdditions =/*Math.round((*/( getAddition1().getPriceOfAddition()+ getAddition2().getPriceOfAddition() +
                getAddition3().getPriceOfAddition() + getAddition4().getPriceOfAddition()+this.coke.getPriceOfAddition()
                +this.chips.getPriceOfAddition())/**100)/100.0)*/;

        System.out.println("Your "+getClass().getSimpleName()+" consists of: \n" +
                "- Bread type: "+ this.getBreadType() + "\n - Meat: "+ this.getMeat() +"\n");
        System.out.println(" Subtotal: Base Price = "+ this.getBasePrice()+ " USD\n");
        System.out.println("Deluxe Additions: \n");
        System.out.println("1. "+ coke.getNameOfAddition()+ " price: "+coke.getPriceOfAddition() +" USD\n");
        System.out.println("2. "+ chips.getNameOfAddition()+ " price: "+chips.getPriceOfAddition() +" USD\n");
        System.out.println(" Subtotal: Price of Deluxe Additions = "+ (coke.getPriceOfAddition()+chips.getPriceOfAddition())+ " USD\n");
        System.out.println(" Additions:\n");

        System.out.println("1. "+ getAddition1().getNameOfAddition()+ " price: "+getAddition1().getPriceOfAddition() +" USD\n");
        System.out.println("2. "+ getAddition2().getNameOfAddition()+ " price: "+getAddition2().getPriceOfAddition() +" USD\n");
        System.out.println("3. "+ getAddition3().getNameOfAddition()+ " price: "+getAddition3().getPriceOfAddition() +" USD\n");
        System.out.println("4. "+ getAddition4().getNameOfAddition()+ " price: "+getAddition4().getPriceOfAddition() +" USD\n");

        System.out.println("Subtotal : Price of Additions = "+totalPriceOfAdditions+ " USD");


        double totalPrice = Math.round((this.getBasePrice() + totalPriceOfAdditions)*100)/100.0;
        System.out.println("Total Price of "+ getClass().getSimpleName() + " = " +totalPrice + " USD");
        System.out.println("*********************************************************************");

        return totalPrice;


    }

    public Addition getCoke() {
        return coke;
    }

    public void setCoke(Addition coke) {
        this.coke = coke;
    }

    public Addition getChips() {
        return chips;
    }

    public void setChips(Addition chips) {
        this.chips = chips;
    }
}
package com.company;

public class Main {

    public static void main(String[] args) {

        Addition carrot = new Addition("carrot", 0.1);
        Addition onions = new Addition("onions", 0.21);
        Addition lettuce = new Addition("lettuce", 0.3);
        Addition tomato = new Addition("tomato", 0.4);
        Addition pickles = new Addition("pickles", 0.52);
        Addition bacon = new Addition("bacon", 0.6);
//        Addition coke = new Addition("coke", 0.35);
//        Addition chips = new Addition("chips", 0.25);
////        Addition no = new Addition ("no",0.0);


        Hamburger hamburger = new Hamburger();
//        hamburger.setAddition1(carrot);
//        System.out.println("Addition 1 = "+ hamburger.getAddition1().getNameOfAddition()+" price USD: "+ hamburger.getAddition1().getPriceOfAddition());
        hamburger.setAddition2(onions);
//        System.out.println("Addition 2 = "+ hamburger.getAddition2().getNameOfAddition()+" price USD: "+ hamburger.getAddition2().getPriceOfAddition());
        hamburger.setAddition3(lettuce);
//        System.out.println("Addition 3 = "+ hamburger.getAddition3().getNameOfAddition()+" price USD: "+ hamburger.getAddition3().getPriceOfAddition());
//        hamburger.setAddition4(no);
//        System.out.println("Addition 4 = "+ hamburger.getAddition4().getNameOfAddition()+" price USD: "+ hamburger.getAddition4().getPriceOfAddition());



        hamburger.priceCalculation();
//        hamburger.choiceOfAddition();
//
        HealthyBurger healthyBurger = new HealthyBurger();
//        healthyBurger.setAddition1(carrot);
//        System.out.println("Addition 1 = "+ healthyBurger.getAddition1().getNameOfAddition()+" price USD: "+ healthyBurger.getAddition1().getPriceOfAddition());
//        healthyBurger.setAddition2(onions);
//        System.out.println("Addition 2 = "+ healthyBurger.getAddition2().getNameOfAddition()+" price USD: "+ healthyBurger.getAddition2().getPriceOfAddition());
        healthyBurger.setAddition3(lettuce);
//        System.out.println("Addition 3 = "+ healthyBurger.getAddition3().getNameOfAddition()+" price USD: "+ healthyBurger.getAddition3().getPriceOfAddition());
        healthyBurger.setAddition4(tomato);
//        System.out.println("Addition 4 = "+ healthyBurger.getAddition4().getNameOfAddition()+" price USD: "+ healthyBurger.getAddition4().getPriceOfAddition());
        healthyBurger.setAddition5(pickles);
//        System.out.println("Addition 5 = "+ healthyBurger.getAddition5().getNameOfAddition()+" price USD: "+ healthyBurger.getAddition5().getPriceOfAddition());
//        healthyBurger.setAddition6(bacon);
//        System.out.println("Addition 6 = "+ healthyBurger.getAddition6().getNameOfAddition()+" price USD: "+ healthyBurger.getAddition6().getPriceOfAddition());

        healthyBurger.priceCalculation();


        DeluxeBurger deluxeBurger = new DeluxeBurger("white", "chicken", 3.0, null, null);
        deluxeBurger.setAddition1(bacon);
//        System.out.println("Addition 1 = "+ hamburger.getAddition1().getNameOfAddition()+" price USD: "+ hamburger.getAddition1().getPriceOfAddition());
        deluxeBurger.setAddition2(onions);
//        System.out.println("Addition 2 = "+ hamburger.getAddition2().getNameOfAddition()+" price USD: "+ hamburger.getAddition2().getPriceOfAddition());
        deluxeBurger.setAddition3(lettuce);
//        System.out.println("Addition 3 = "+ hamburger.getAddition3().getNameOfAddition()+" price USD: "+ hamburger.getAddition3().getPriceOfAddition());
        deluxeBurger.setAddition4(pickles);
//        deluxeBurger.setChips(no);
        deluxeBurger.priceCalculation();

        deluxeBurger.setCoke(new Addition("7up", 0.45));
//        System.out.println("Addition 4 = "+ hamburger.getAddition4().getNameOfAddition()+" price USD: "+ hamburger.getAddition4().getPriceOfAddition());



        deluxeBurger.priceCalculation();

    }
}
