class MyThread extends Thread {
    public void run() {
        System.out.println("Thread '" + getName() + "' is running with ID: " + getId());
        try {
            // Simulate some work
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread '" + getName() + "' has finished.");
    }
}

class q2 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        
        
        thread.setName("MyCustomThread");
        
        // Display the thread name
        System.out.println("Thread Name: " + thread.getName());
        
        // Get and display the thread ID
        System.out.println("Thread ID: " + thread.getId());
        
        // Check if thread is alive before starting
        System.out.println("Is Thread Alive before start: " + thread.isAlive());
        
        // Start the thread
        thread.start();
        
        // Check if thread is alive after starting
        System.out.println("Is Thread Alive after start: " + thread.isAlive());
        
        // Wait for the thread to complete
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Check if thread is alive after completion
        System.out.println("Is Thread Alive after finish: " + thread.isAlive());
    }
}