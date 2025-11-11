import java.util.Scanner;

class SquareThread extends Thread {
    private int num;
    SquareThread(int num) { this.num = num; }
    public void run() {
        int square = num * num;
        System.out.println("Square of " + num + " is: " + square);
    }
}

class SumOfDigitsThread extends Thread {
    private int num;
    SumOfDigitsThread(int num) { this.num = num; }
    public void run() {
        int sum = 0, temp = num;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        System.out.println("Sum of digits of " + num + " is: " + sum);
    }
}

public class q6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        SquareThread t1 = new SquareThread(num);
        SumOfDigitsThread t2 = new SumOfDigitsThread(num);
        t1.start();
        t2.start();
    }
}
