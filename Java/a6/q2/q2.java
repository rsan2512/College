package Java.a6.q2;
interface Calculator {
    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    int div(int a, int b);
}

class DemoCalculator implements Calculator {
    public int add(int a, int b) { return a + b; }
    public int sub(int a, int b) { return a - b; }
    public int mul(int a, int b) { return a * b; }
    public int div(int a, int b) { return a / b; }
}

public class q2 {
    public static void main(String[] args) {
        Calculator c = new DemoCalculator();
        System.out.println("Add: " + c.add(10, 5));
        System.out.println("Sub: " + c.sub(10, 5));
        System.out.println("Mul: " + c.mul(10, 5));
        System.out.println("Div: " + c.div(10, 5));
    }
}
