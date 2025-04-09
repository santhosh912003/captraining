import java.util.HashMap;
import java.util.Map;

public class encap5 {
    public static void main(String[] args) {
        Map<Integer, Integer> r = new HashMap<>();
        Book b = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", r);
        Magazine m = new Magazine(2, "National Geographic", "Various", r);
        Dvd d = new Dvd(3, "Inception", "Christopher Nolan", r);
        System.out.println("Library Items:");
        
        System.out.println(b.getItemDetails());
        System.out.println("Loan Duration: " + b.getLoanDuration() + " days");
        b.reserveItem();

        System.out.println(m.getItemDetails());
        System.out.println("Loan Duration: " + m.getLoanDuration() + " days");

        System.out.println(d.getItemDetails());
        System.out.println("Loan Duration: " + d.getLoanDuration() + " days");
        d.reserveItem();

        System.out.println("Checking availability for all items:");
        System.out.println("Book available: " + b.checkAvailability());
        System.out.println("Magazine available: " + m.checkAvailability());
        System.out.println("Dvd available: " + d.checkAvailability());

        
    }
    
}

abstract class LibraryItem{
    int itemId;
    String title;
    String author;
    LibraryItem(int itemId, String title, String author){
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    public int getItemId() {
        return itemId;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    abstract int getLoanDuration();
    String getItemDetails(){
        return "Item ID: " + this.itemId + ", Title: " + this.title + ", Author: " + this.author;
    }
}
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}
class Book extends LibraryItem implements Reservable{
    Map<Integer,Integer> reservations = new HashMap<>();
    public Book(int itemId, String title, String author, Map<Integer,Integer> reservations){
        super(itemId, title, author);
        this.reservations = reservations;
        reservations.put(itemId, 1);
    }
    @Override
    public void reserveItem(){
        if(reservations.containsKey(itemId) && reservations.get(itemId)==0){
            System.out.println("Book" + super.getTitle() +"already reserved.");
        } else {
            reservations.put(itemId, 0);
            System.out.println("Book" + super.getTitle() +" reserved successfully.");
        }
    }
    @Override
    public boolean checkAvailability(){
        return reservations.get(this.itemId)==1;
    }
    @Override
    int getLoanDuration(){
        if(checkAvailability()){
            return 14;
        }  else{
            System.out.println("Book " + super.getTitle() + " is not available. hence not applicable for loan ! ");
            return -1;
        }
    }
}
class Magazine extends LibraryItem implements Reservable{
    Map<Integer,Integer> reservations = new HashMap<>();
    public Magazine(int itemId, String title, String author, Map<Integer,Integer> reservations){
        super(itemId, title, author);
        this.reservations = reservations;
        reservations.put(itemId, 1);
    }
    @Override
    public void reserveItem(){
        if(reservations.containsKey(itemId) && reservations.get(itemId)==0){
            System.out.println("Magazine" + super.getTitle() +"already reserved.");
        } else {
            reservations.put(itemId, 0);
            System.out.println("Magazine" + super.getTitle() +" reserved successfully.");
        }
    }
    @Override
    public boolean checkAvailability(){
        return reservations.get(this.itemId)==1;
    }
    @Override
    int getLoanDuration(){
        if(checkAvailability()){
            return 7;
        }  else{
            System.out.println("Magazine " + super.getTitle() + " is not available. hence not applicable for loan ! ");
            return -1;
        }
    }
}
class Dvd extends LibraryItem implements Reservable{
    Map<Integer,Integer> reservations = new HashMap<>();
    public Dvd(int itemId, String title, String author, Map<Integer,Integer> reservations){
        super(itemId, title, author);
        this.reservations = reservations;
        reservations.put(itemId, 1);
    }
    @Override
    public void reserveItem(){
        if(reservations.containsKey(itemId) && reservations.get(itemId)==0){
            System.out.println("Dvd" + super.getTitle() +"already reserved.");
        } else {
            reservations.put(itemId, 0);
            System.out.println("Dvd" + super.getTitle() +" reserved successfully.");
        }
    }
    @Override
    public boolean checkAvailability(){
        return reservations.get(this.itemId)==1;
    }
    @Override
    int getLoanDuration(){
        if(checkAvailability()){
            return 5;
        }  else{
            System.out.println("Dvd " + super.getTitle() + " is not available. hence not applicable for loan ! ");
            return -1;
        }
    }
}