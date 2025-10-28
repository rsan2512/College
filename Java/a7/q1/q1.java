import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2;
        double result;

        System.out.print("Enter numerator (n1): ");
        n1 = sc.nextInt();

        while (true) {
            System.out.print("Enter denominator (n2): ");
            n2 = sc.nextInt();

            try {
                result =  n1 / n2;
                System.out.println("Result: " + result);
                break; // Exit loop if successful
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero is not allowed. Please enter n2 again.");
            }
        }

        System.out.println("Program finished successfully!");
        sc.close();
    }
}
