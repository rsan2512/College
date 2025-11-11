import java.util.Scanner;

class SumThread extends Thread {
    int start, end;
    static long sum = 0;
    static Object lock = new Object();
    SumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public void run() {
        long partial = 0;
        for (int i = start; i <= end; i++) partial += i;
        synchronized (lock) {
            sum += partial;
        }
    }
}

public class q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of threads: ");
        int m = sc.nextInt();
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();
        SumThread[] threads = new SumThread[m];
        int range = n / m;
        int start = 1;
        for (int i = 0; i < m; i++) {
            int end = (i == m - 1) ? n : start + range - 1;
            threads[i] = new SumThread(start, end);
            threads[i].start();
            start = end + 1;
        }
        for (int i = 0; i < m; i++) {
            try { threads[i].join(); } catch (InterruptedException e) {}
        }
        System.out.println("Sum of first " + n + " natural numbers: " + SumThread.sum);
    }
}
