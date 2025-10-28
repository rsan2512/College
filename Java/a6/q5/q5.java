package Java.a6.q5;
interface Servicing {
    int getServiceTime();
}

class Car implements Servicing {
    public int getServiceTime() {
        return 2;
    }
}

class Bike implements Servicing {
    public int getServiceTime() {
        return 1;
    }
}

public class q5 {
    public static void main(String[] args) {
        Servicing s;

        s = new Car();
        System.out.println("Car Service Time: " + s.getServiceTime() + " hours");

        s = new Bike();
        System.out.println("Bike Service Time: " + s.getServiceTime() + " hours");
    }
}
