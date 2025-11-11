import java.util.Scanner;

class OddPrinter extends Thread {
    private int m, n;
    
    public OddPrinter(int m, int n) {
        this.m = m;
        this.n = n;
    }
    
    @Override
    public void run() {
        for (int i = m; i <= n; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m: ");
        int m = sc.nextInt();
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        sc.close();
        
        OddPrinter oddThread = new OddPrinter(m, n);
        oddThread.start();
        
        for (int i = m; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}