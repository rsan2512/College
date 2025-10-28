import java.util.Scanner;

// User-defined exception
class MinimumBalanceException extends Exception {
    public MinimumBalanceException(String message) {
        super(message);
    }
}

// Account class (not public)
class Account {
    String name;
    int acc_no;
    double balance;

    public Account(String name, int acc_no, double balance) {
        this.name = name;
        this.acc_no = acc_no;
        this.balance = balance;
    }

    public void deposit(double amt) {
        balance += amt;
        System.out.println("Amount deposited: " + amt);
        System.out.println("New balance: " + balance);
    }

    public void withdraw(double amt) throws MinimumBalanceException {
        if (balance - amt < 500) {
            throw new MinimumBalanceException("Cannot withdraw " + amt +
                ". Minimum balance of 500 must be maintained. Current balance: " + balance);
        }
        balance -= amt;
        System.out.println("Amount withdrawn: " + amt);
        System.out.println("Remaining balance: " + balance);
    }

    public void display() {
        System.out.println("Account Number: " + acc_no);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: " + balance);
    }
}

// Main class with main() method → must be public and match filename
public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        int acc_no = sc.nextInt();

        System.out.print("Enter initial balance (>=500): ");
        double balance = sc.nextDouble();

        Account acc = new Account(name, acc_no, balance);

        System.out.print("Enter amount to deposit: ");
        double depositAmt = sc.nextDouble();
        acc.deposit(depositAmt);

        while (true) {
            System.out.print("Enter amount to withdraw: ");
            double withdrawAmt = sc.nextDouble();
            try {
                acc.withdraw(withdrawAmt);
                break;
            } catch (MinimumBalanceException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Try withdrawing a smaller amount.");
            }
        }

        System.out.println("\nFinal Account Details:");
        acc.display();
        sc.close();
    }
}
