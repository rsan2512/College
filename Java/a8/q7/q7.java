import java.util.Scanner;

class TableThread extends Thread {
    private int num;
    TableThread(int num) { this.num = num; }
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Table: " + num + " x " + i + " = " + (num * i));
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }
}

class FactorialThread extends Thread {
    private int num;
    FactorialThread(int num) { this.num = num; }
    public void run() {
        long fact = 1;
        for (int i = 1; i <= num; i++) fact *= i;
        System.out.println("Factorial of " + num + " is: " + fact);
    }
}

public class q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        TableThread t1 = new TableThread(num);
        FactorialThread t2 = new FactorialThread(num);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}
        System.out.println("Main thread finished after both threads completed.");
    }
}
