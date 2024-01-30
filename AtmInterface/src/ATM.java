package CODSOFT.AtmInterface.src;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("\nATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void executeOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayOptions();
            System.out.print("Enter option: ");
            int option = atm.scanner.nextInt();

            atm.executeOption(option);
        }
    }
}
