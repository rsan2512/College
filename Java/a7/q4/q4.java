package Java.a7.q4;

import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50};

        try {
            // Ask for array index
            System.out.print("Enter array index to access: ");
            int index = sc.nextInt();

            // Ask for divisor
            System.out.print("Enter a number to divide arr[index] by: ");
            int divisor = sc.nextInt();

            // Access array element
            int value = arr[index];

            // Perform division
            int result = value / divisor;

            System.out.println("Result: " + result);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds! Please enter a valid index.");

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed!");

        } catch (Exception e) {
            System.out.println("Error: Some unexpected exception occurred: " + e);
        }

        System.out.println("Program finished successfully!");
        sc.close();
    }
}
 
    

