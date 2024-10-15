import java.util.ArrayList;
import java.util.Date;

class Transaction {
    private Date date;
    private char type; // '+' for deposit, '-' for withdrawal
    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description) {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", type=" + type +
                ", amount=" + amount +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}

class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private ArrayList<Transaction> transactions;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction('+', amount, balance, "Deposit"));
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction('-', amount, balance, "Withdrawal"));
        }
    }

    public double getMonthlyInterest() {
        return (annualInterestRate / 100) / 12 * balance;
    }

    public void displayAccountSummary() {
        System.out.println("Account ID: " + id);
        System.out.println("Balance: " + balance);
        System.out.println("Annual Interest Rate: " + annualInterestRate);
        System.out.println("Date Created: " + dateCreated);
        System.out.println("Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1233, 1100, 7.5);

        account.deposit(500);
        account.deposit(600);
        account.withdraw(700);
        account.withdraw(600);
        account.withdraw(100);

        account.displayAccountSummary();
    }
}
