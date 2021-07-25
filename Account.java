import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
    private String customerName;
    private String customerID;
    private int balance = 0;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    public boolean deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            return true;
        }
        return false;
    }

    public boolean withdraw(int amount) {
        if ((balance - amount < 0) || (amount <= 0)) {
            return false;
        }
        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount));
        return true;
    }

    public void getTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("There is no recorded transaction yet!");
        } else {
            System.out.println("========================================");
            for (Transaction transaction : transactions) {
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
                System.out.println(formatter.format(transaction.gettDate()) + " | " + transaction.gettType() + ": $" + transaction.gettAmount());
            }
            System.out.println("========================================");
        }
    }

    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View the transaction history");
        System.out.println("E. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("========================================");
                    System.out.println("Balance: $" + balance);
                    System.out.println("========================================");
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int dAmount = scanner.nextInt();
                    if (deposit(dAmount)) {
                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("There was something wrong with the deposit!");
                    }
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int wAmount = scanner.nextInt();
                    if (withdraw(wAmount)) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("There was something wrong with the withdraw!");
                    }
                    System.out.println();
                    break;
                case 'D':
                    getTransactions();
                    break;
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D or E.");
                    break;
            }
        } while(option != 'E');
        System.out.println("Thank you for banking with us!");
    }
}
