import java.util.*;

class encap2 {
    public static void main(String[] args) {
     
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 50000, 18));
        products.add(new Clothing(202, "T-Shirt", 1000, 5));
        products.add(new Groceries(303, "Apple", 200, 2));

        printFinalPrice(products);
    }

    public static void printFinalPrice(List<Product> products) {
        for (Product product : products) {
            product.calculateDiscount(); 

            double tax = 0;
            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                taxableProduct.calculateTax();
                tax = taxableProduct.getTax();
            }

            double finalPrice = product.getPrice() + tax; 
            System.out.println(product.getName() + " Final Price after Tax and Discount: " + finalPrice);
            System.out.println("-------------------------------------------------");
        }
    }
}

// Abstract Product class
abstract class Product {
    protected int id;
    protected String name;
    protected double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    abstract void calculateDiscount();
}

interface Taxable {
    void calculateTax();
    double getTax();
}

class Electronics extends Product implements Taxable {
    private int taxPercent;
    private double tax;

    public Electronics(int id, String name, double price, int taxPercent) {
        super(id, name, price);
        this.taxPercent = taxPercent;
    }

    @Override
    void calculateDiscount() {
        this.price -= 500;
    }

    @Override
    public void calculateTax() {
        this.tax = this.price * (this.taxPercent / 100.0);
    }

    @Override
    public double getTax() {
        return this.tax;
    }
}

class Clothing extends Product implements Taxable {
    private int taxPercent;
    private double tax;

    public Clothing(int id, String name, double price, int taxPercent) {
        super(id, name, price);
        this.taxPercent = taxPercent;
    }

    @Override
    void calculateDiscount() {
        this.price -= 50; 
    }

    @Override
    public void calculateTax() {
        this.tax = this.price * (this.taxPercent / 100.0);
    }

    @Override
    public double getTax() {
        return this.tax;
    }
}


class Groceries extends Product implements Taxable {
    private int taxPercent;
    private double tax;

    public Groceries(int id, String name, double price, int taxPercent) {
        super(id, name, price);
        this.taxPercent = taxPercent;
    }

    @Override
    void calculateDiscount() {
        this.price -= 10; 
    }

    @Override
    public void calculateTax() {
        this.tax = this.price * (this.taxPercent / 100.0);
    }

    @Override
    public double getTax() {
        return this.tax;
    }
}