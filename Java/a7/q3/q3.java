import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example array
        int[] arr = {10, 20, 30, 40, 50};
        int index;

        System.out.println("Array elements: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nArray size: " + arr.length);

        while (true) {
            System.out.print("Enter index to access: ");
            index = sc.nextInt();

            try {
                System.out.println("Element at index " + index + " is " + arr[index]);
                break; // exit loop if successful
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Index out of bounds! Please enter index between 0 and " + (arr.length - 1));
            }
        }

        System.out.println("Program finished successfully!");
        sc.close();
    }
}
