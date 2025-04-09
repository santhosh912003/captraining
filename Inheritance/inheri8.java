class inheri8 {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(101, 5000, 4.5);
        savings.displayAccountType();
        savings.getAccountDetails();

        CheckingAccount checking = new CheckingAccount(102, 2000, 1000);
        checking.displayAccountType();
        checking.getAccountDetails();

        FixedDepositAccount fixedDeposit = new FixedDepositAccount(103, 10000, 5.0, 2);
        fixedDeposit.displayAccountType();
        fixedDeposit.getAccountDetails();
    }
}

class BankAccount {
    int accountNumber;
    double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void getAccountDetails() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("This is a Savings Account with Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    public CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("This is a Checking Account with Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    double interestRate;
    int depositTerm;

    public FixedDepositAccount(int accountNumber, double balance, double interestRate, int depositTerm) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
        this.depositTerm = depositTerm;
    }

    void displayAccountType() {
        System.out.println("This is a Fixed Deposit Account with Interest Rate: " + interestRate + "% for " + depositTerm + " years.");
    }
}