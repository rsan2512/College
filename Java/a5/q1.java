package Java.a5;

class Account {
    String customerName;
    int accountNumber;
    Account(String name, int number) {
        customerName = name;
        accountNumber = number;
    }
    void display() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Number: " + accountNumber);
  }   }
class Savings_Account extends Account {
    double minBal;
    double savingBal;
    Savings_Account(String name, int number, double minBal, double savingBal) {
        super(name, number); // Call base class constructor
        this.minBal = minBal;
        this.savingBal = savingBal;
    }
    void show() {
        display(); 
        System.out.println("Minimum Balance: " + minBal);
        System.out.println("Saving Balance: " + savingBal);
  }  }
class Account_details extends Savings_Account {
    double deposit;
    double withdrawal;
    Account_details(String name, int number, double minBal, double savingBal, double deposit, double withdrawal) {
        super(name, number, minBal, savingBal); 
        this.deposit = deposit;
        this.withdrawal = withdrawal;
    }
    void show1() {
        show(); // Call Savings_Account show
        System.out.println("Deposit Amount: " + deposit);
        System.out.println("Withdrawal Amount: " + withdrawal);
 } }
public class q1 {
    public static void main(String[] args) {
          Account_details customer1 = new Account_details("Roshan", 12345, 5000.0, 20000.0,3000.0,1000.0);
         System.out.println("----- Customer Account Details -----");
        customer1.show1();
    }
  }
