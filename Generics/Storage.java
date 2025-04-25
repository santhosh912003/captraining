// Concepts: Generic Classes, Bounded Type Parameters, Wildcards
// Problem Statement:
// You are developing a Smart Warehouse System that manages different types of items like Electronics, Groceries, and Furniture. The system should be able to store and retrieve items dynamically while maintaining type safety.
// Hints:
// Create an abstract class WarehouseItem that all items extend (Electronics, Groceries, Furniture).
// Implement a generic class Storage<T extends WarehouseItem> to store items safely.
// Implement a wildcard method to display all items in storage regardless of their type (List<? extends WarehouseItem>).

import java.util.ArrayList;
abstract class WarehouseItem{
    private String name;
    private double price;
    public WarehouseItem(String name, double price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    abstract void display();
}
class Electronics extends WarehouseItem{
    public Electronics(String name, double price){
        super(name, price);
    }
    public void display(){
        System.out.println("electronics name : "+ getName()+" price : "+getPrice());
    }
}
class Groceries extends WarehouseItem{
    public Groceries(String name, double price){
        super(name, price);
    }
    public void display(){
        System.out.println("groceries name : "+ getName()+" price : "+getPrice());
    }
}
class Furniture extends WarehouseItem{
    public Furniture(String name, double price){
        super(name, price);
    }
    public void display(){
        System.out.println("furniture name : "+ getName()+" price : "+getPrice());
    }
}
public class Storage<T extends WarehouseItem> {
    ArrayList<T> storage = new ArrayList<>();
    public void addItem(T item){
        storage.add(item);
    }
    public ArrayList<T> getItems(){
        return this.storage;
    }
    public static  void displayAllItems(ArrayList< ? extends WarehouseItem> list){
        for (WarehouseItem item : list){
            item.display();
        }

    }
    public static void main(String[] args) {
        Storage<WarehouseItem> warehouse = new Storage<>();
        warehouse.addItem(new Electronics("Laptop", 75000));
        warehouse.addItem(new Groceries("Milk", 60));
        warehouse.addItem(new Furniture("Table", 4500));
        warehouse.addItem(new Electronics("Camera", 30000));
        warehouse.addItem(new Groceries("Bananas", 50));

        System.out.println("---- All Warehouse Items ----");
        displayAllItems(warehouse.getItems());
    }
}