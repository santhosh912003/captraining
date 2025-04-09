// Bank class
class Bank {
    private String bankName;
    private String branch;

    public Bank(String bankName, String branch) {
        this.bankName = bankName;
        this.branch = branch;
    }

    public void displayBankDetails() {
        System.out.println("Bank: " + bankName + " | Branch: " + branch);
    }

    public String getBankName() {
        return bankName;
    }

    public String getBranch() {
        return branch;
    }
}

// Customer class (not inheriting Bank)
class Customer {
    private String name;
    private String accountNumber;
    private double balance;
    private Bank bank;  // COMPOSITION: Customer HAS-A Bank

    public Customer(String name, String accountNumber, Bank bank) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(name + " deposited ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(name + " withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void displayDetails() {
        System.out.println("\nCustomer Name: " + name);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
        bank.displayBankDetails();  // Display associated bank
    }
}

// Main class
public class sample1 {
    public static void main(String[] args) {
        Bank sbi = new Bank("SBI", "Anna Nagar");
        Customer c1 = new Customer("Meena", "SB10101", sbi);

        c1.displayDetails();
        c1.deposit(10000);
        c1.withdraw(2500);
        c1.displayDetails();
    }
}