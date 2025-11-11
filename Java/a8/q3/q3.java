import java.util.Scanner;

class ArmstrongChecker implements Runnable {
    private int num;
    
    public ArmstrongChecker(int num) {
        this.num = num;
    }
    
    @Override
    public void run() {
        int original = num;
        int sum = 0;
        int digits = 0;
        int temp = num;
        
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        
        temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, digits);
            temp /= 10;
        }
        
        if (sum == original) {
            System.out.println(original + " is an Armstrong number.");
        } else {
            System.out.println(original + " is not an Armstrong number.");
        }
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();
        
        ArmstrongChecker checker = new ArmstrongChecker(num);
        Thread thread = new Thread(checker);
        thread.start();
    }
}