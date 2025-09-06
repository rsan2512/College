package Java.a3;

import java.util.Scanner;
public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.print("Enter element to search: ");
        int x = sc.nextInt();
        boolean found = false;
        for(int i=0; i<n; i++) {
            if(arr[i]==x) { found=true; break; }
        }
        if(found) System.out.println(x+" found in the array.");
        else System.out.println(x+" not found in the array.");
    }
}
