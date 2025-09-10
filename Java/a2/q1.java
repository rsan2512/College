package Java.a2;
import java.util.Scanner;
public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your income: ");
        double income = sc.nextDouble();
        double taxRate;

        if (income > 500000) {
            taxRate = income * 0.3;
        } else if (income > 300000) {
            taxRate = income * 0.2;
        } else if (income > 150000) {
            taxRate = income * 0.1;
        } else {
            taxRate = 0;
        }
        System.out.println("Your calculated tax on the income is " + taxRate);
    }
}

