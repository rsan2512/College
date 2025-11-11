class MyThread extends Thread {
    MyThread(String name) {
        super(name);
    }
    public void run() {
        System.out.println(getName() + " is running with priority " + getPriority());
    }
}

public class q8{
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-One");
        MyThread t2 = new MyThread("Thread-Two");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.getName() + " Priority: " + t1.getPriority());
        System.out.println(t2.getName() + " Priority: " + t2.getPriority());
        t1.start();
        t2.start();
    }
}
