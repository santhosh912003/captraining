import java.util.ArrayList;

// Customer class
class Customer {
    String name;
    String accountNumber;
    double balance;

    public Customer(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println();
    }
}

// Bank class
class Bank {
    String bankName;
    ArrayList<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void showAllCustomers() {
        System.out.println("Bank: " + bankName);
        System.out.println("---- Customer Details ----");
        for (Customer c : customers) {
            c.displayDetails();
        }
    }
}

// Main class
public class sample2 {
    public static void main(String[] args) {
        Bank bank = new Bank("HDFC Bank");

        Customer c1 = new Customer("Rajesh", "ACC12345", 5000.0);
        Customer c2 = new Customer("Aishwarya", "ACC67890", 12000.0);

        bank.addCustomer(c1);
        bank.addCustomer(c2);

        bank.showAllCustomers();
    }
}