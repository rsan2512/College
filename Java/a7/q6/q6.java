import java.util.Scanner;
import java.util.InputMismatchException;

public class q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double feet = 0, inches = 0;

        while (true) {
            try {
                System.out.print("Enter length in feet: ");
                feet = sc.nextDouble();
                if (feet < 0) {
                    throw new IllegalArgumentException("Feet cannot be negative!");
                }

                System.out.print("Enter remaining inches: ");
                inches = sc.nextDouble();
                if (inches < 0) {
                    throw new IllegalArgumentException("Inches cannot be negative!");
                }

                // Conversion
                double totalInches = feet * 12 + inches;
                double cm = totalInches * 2.54;

                System.out.println(feet + " feet and " + inches + " inches = " + cm + " cm");
                break; // exit loop if successful

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter numeric values only!");
                sc.nextLine(); // clear the invalid input

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Conversion complete!");
        sc.close();
    }
}
