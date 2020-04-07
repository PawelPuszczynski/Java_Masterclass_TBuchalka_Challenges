package com.company;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);

            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }


    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList () {
        Map<String, Double>  prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem>  item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\n Stock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Available :" +
                    (stockItem.quantityInStock()-stockItem.getReserved()) +
                    ". Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;

        }
        return s + " Total stock value " + String.format("%.2f",totalCost);

    }
}
package com.company;

import java.util.Map;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock = 0;
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
        this.reserved =0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void setQuantityStock ( int quantityStock){
            this.quantityStock = quantityStock;
        }

    public void adjustStock (int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >=0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj ==this) {
            return true;
        }
        if ((obj==null) || (obj.getClass() !=this.getClass())) {
            return false;
        }
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() +31;
    }

    @Override
    public int compareTo(StockItem o) {
        if (this == o) {
            return 0;
        }
        if (o!= null ) {
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
package com.company;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<StockItem, Integer> getList() {
        return list;
    }

    public int addToBasket (StockItem item, int quantity) {
        int inBasket = list.getOrDefault(item, 0);
        if ((item != null) && (quantity >0) ){
          if (item.quantityInStock()-item.getReserved() - quantity >=0) {
              list.put(item, inBasket + quantity);
              int tempReservedQuantity = item.getReserved();
              item.setReserved(tempReservedQuantity+quantity);

              System.out.println("\naddToBasket called*****************");
              System.out.println(quantity + " "+ item.getName() + "(s) added to the basket. Total total number of " +
                       item.getName()+ "(s) in this basket :" +
                      (inBasket+quantity));

              return inBasket;
          }
          else {
              System.out.println("Not enough available stock of this item to reserve.");
          }
      }
      if ((item !=null) && (quantity<0)) {
          int tempReservedQuantity = item.getReserved();
          item.setReserved(tempReservedQuantity + quantity);// decreases reserved quantity
          list.put(item, inBasket + quantity);
          System.out.println("\n"+ (-quantity) + " " + item.getName() + "(s) successfully unreserved. " +
                  "Total total number of " + item.getName()+ "(s) in this basket : " + (inBasket+quantity));
      }
      return 0;
    }
    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    public void checkOut () {
        System.out.println("\nChecking out: "+ this.getName()+ "'s basket...");

        System.out.println(this.toString());

        int numberOfItemsInBasket;
        int currentStock;
        int reservedItems;

        for ( Map.Entry<StockItem, Integer> itemToCheckout: this.list.entrySet()) {
            numberOfItemsInBasket = itemToCheckout.getValue();
            reservedItems = itemToCheckout.getKey().getReserved();
            itemToCheckout.getKey().setReserved(reservedItems-numberOfItemsInBasket);

            currentStock = itemToCheckout.getKey().quantityInStock();

            itemToCheckout.getKey().setQuantityStock(currentStock-numberOfItemsInBasket);
            // emptying the Basket
        }
            list.clear();
            System.out.println("Emptying " +this.getName()+ "'s basket...");
            System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains "+ list.size() + ((list.size() ==1) ? " item \n"  : " items \n");
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s= s + item.getKey() + " . " + item.getValue() + " added to basket\n";
            totalCost +=item.getKey().getPrice() * item.getValue();

        }
        return s + " Total cost  " + String.format("%.2f",totalCost) + "\n";
    }
}
package com.company;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);
        temp = new StockItem("cake", 1.1, 7);
        stockList.addStock(temp);
        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);
        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);
        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);
        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);
        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);
        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);
        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        stockList.Items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-1000);
        System.out.println(stockList);

        Basket timsBasket = new Basket("Tim");
        putItemInBasket(timsBasket, "car", 1);
        putItemInBasket(timsBasket, "car", 1);

        System.out.println(stockList);

        putItemInBasket(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        putItemInBasket(timsBasket, "juice", 4);
        putItemInBasket(timsBasket, "cup", 12);
        putItemInBasket(timsBasket, "bread", 1);
        System.out.println(timsBasket);
        System.out.println(stockList);

        Basket paulsBasket = new Basket("Paul");
        putItemInBasket(paulsBasket, "car", 100);
        putItemInBasket(paulsBasket, "vase", 2);
        putItemInBasket(paulsBasket, "towel", 10);
        putItemInBasket(paulsBasket, "phone", 1);
        putItemInBasket(paulsBasket,"car", -1000);
        System.out.println(paulsBasket);
        System.out.println(stockList);

        // UNRESERVING ITEMS***************************
        unreserve(timsBasket, "car", 4);
        unreserve(timsBasket, "vase", 1);
        unreserve(timsBasket, "car", 1);

        unreserve(paulsBasket, "vase", 1);


        //CHECKING OUT**********************
        System.out.println(stockList);

        timsBasket.checkOut();
        System.out.println(stockList);

        paulsBasket.checkOut();
        System.out.println(stockList);
    }

    public static void unreserve(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if ((basket.getList().get(stockItem) != null) && ((basket.getList().get(stockItem) > 0))) {

            if ((basket.getList().get(stockItem)) >= quantity) {
                basket.addToBasket(stockItem, -quantity);
            } else {
                System.out.println("\nYou can unreserve (remove from this basket) max : " + basket.getList().get(stockItem) +
                        " " + stockItem.getName() + "(s) only.");
            }
        } else {
            System.out.println("No " + stockItem.getName() + " item  in : " + basket.getName() +
                    "'s basket. Cannot unreserve this item.");
        }
    }

    public static int putItemInBasket(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println(" We don't sell " + item);
            return 0;
        }
        if (stockItem.quantityInStock() != 0) {
            if (quantity >= 0) {
                basket.addToBasket(stockItem, quantity);
                return quantity;
            } else {
                System.out.println("\nCannot add negative quantity to the basket.");
            }
        }
        return 0;
    }
}
