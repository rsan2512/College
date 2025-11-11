import java.util.Scanner;

class PrimePalindromeChecker extends Thread {
    private int num;
    
    public PrimePalindromeChecker(int num) {
        this.num = num;
    }
    
    @Override
    public void run() {
        String str = Integer.toString(num);
        String rev = new StringBuilder(str).reverse().toString();
        if (str.equals(rev)) {
            System.out.println(num + " is a palindrome.");
        } else {
            System.out.println(num + " is not a palindrome.");
        }
    }
}

public class q4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        sc.close();
        
        PrimePalindromeChecker checker = new PrimePalindromeChecker(num);
        checker.start();
        
        if (num <= 1) {
            System.out.println(num + " is neither prime nor composite.");
        } else {
            boolean isPrime = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(num + " is prime.");
            } else {
                System.out.println(num + " is composite.");
            }
        }
    }
}