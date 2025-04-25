// 2. Dynamic Online Marketplace
// Concepts: Type Parameters, Generic Methods, Bounded Type Parameters
// Problem Statement:
// Build a generic product catalog for an online marketplace that supports various product types like Books, Clothing, and Gadgets. Each product type has a specific price range and category.
// Hints:
// Define a generic class Product<T> where T is restricted to a category (BookCategory, ClothingCategory, etc.).
// Implement a generic method to apply discounts dynamically (<T extends Product> void applyDiscount(T product, double percentage)).
// Ensure type safety while allowing multiple product categories to exist in the same catalog.

interface Category {
    String getCategoryName();
}
enum BookCategory implements Category {
    FICTION, NONFICTION, EDUCATIONAL;

    public String getCategoryName() {
        return this.name(); 
    }
}
enum ClothingCategory implements Category {
    FASHION, SPORTS, ACCESSORIES;
    public String getCategoryName() {
        return this.name(); 
    }
}
enum GadgetCategory implements Category {
    SMARTPHONES, LAPTOPS, TABLETS;
    public String getCategoryName() {
        return this.name();
    }
}

public class Product<T extends Category> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
    public T getCategory() {
        return this.category;
    }
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        System.out.println("Discount applied to " + product.getName() + " (" + product.getCategory
        ().getCategoryName() + "): " + discount);
    }
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Harry Potter", 19.99, BookCategory
        .FICTION);
        Product<ClothingCategory> clothing = new Product<>("Nike T-Shirt", 29.99
        , ClothingCategory.FASHION);
        Product<GadgetCategory> gadget = new Product<>("Apple iPhone", 999.99
        , GadgetCategory.SMARTPHONES);
        applyDiscount(book, 10);
        applyDiscount(clothing, 20);
        applyDiscount(gadget, 15);
        
    }
}