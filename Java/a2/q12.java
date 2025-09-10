package Java.a2;
import java.util.Scanner;
public class q12 {
    //	Q12. Write a recursive program to find the sum of n natural numbers. [n is user input]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("The sum of first " + n + " natural numbers is " + sum(n));
    }

    private static int sum(int n) {
        if (n == 0) {
            return n;
        }
        return n + sum(n - 1);
    }
}

