public class q1 {
    public static void main(String[] args) {
        // Create a reference to a Thread object
        Thread myThread = new Thread("MyCustomThread");

        // Display the details of the thread reference
        System.out.println("Class: " + myThread.getClass().getName());
        System.out.println("Name of Thread: " + myThread.getName());
        System.out.println("Priority: " + myThread.getPriority());
        System.out.println("Group Name: " + myThread.getThreadGroup().getName());
    }
}