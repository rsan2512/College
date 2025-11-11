import java.util.Scanner;

class MinThread extends Thread {
    int[] arr;
    int start, end;
    static int globalMin = Integer.MAX_VALUE;
    static Object lock = new Object();
    MinThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    public void run() {
        int localMin = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < localMin)
                localMin = arr[i];
        }
        synchronized (lock) {
            if (localMin < globalMin)
                globalMin = localMin;
        }
    }
}

public class q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print("Enter number of threads: ");
        int m = sc.nextInt();
        MinThread[] threads = new MinThread[m];
        int range = n / m;
        int start = 0;
        for (int i = 0; i < m; i++) {
            int end = (i == m - 1) ? n - 1 : start + range - 1;
            threads[i] = new MinThread(arr, start, end);
            threads[i].start();
            start = end + 1;
        }
        for (int i = 0; i < m; i++) {
            try { threads[i].join(); } catch (InterruptedException e) {}
        }
        System.out.println("Minimum element in the array: " + MinThread.globalMin);
    }
}
