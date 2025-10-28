import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x, y, result;

        System.out.print("Enter value of x: ");
        x = sc.nextDouble();

        System.out.print("Enter value of y: ");
        y = sc.nextDouble();

        try {
            if (x - y == 0) {
                throw new ArithmeticException("Denominator (x - y) cannot be zero!");
            }

            result = x / (x - y);
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program finished!");
        sc.close();
    }
}
