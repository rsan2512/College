package Java.a2;
import java.util.Scanner;

public class q5 {
    //	Q5. Write a program to find out the factorial of any inputted number.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int fact = 1;

        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        System.out.println("The factorial of " + num + " is " + fact);
    }
}

