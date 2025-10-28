

abstract class Shape {
    abstract void RectangleArea(double length, double breadth);
    abstract void SquareArea(double side);
    abstract void CircleArea(double radius);
}

class Area extends Shape {
    void RectangleArea(double length, double breadth) {
        System.out.println("Rectangle Area: " + (length * breadth));
    }
    void SquareArea(double side) {
        System.out.println("Square Area: " + (side * side));
    }
    void CircleArea(double radius) {
        System.out.println("Circle Area: " + (3.14 * radius * radius));
    }
}

public class q3 {
    public static void main(String[] args) {
        Area a = new Area();
        a.RectangleArea(10, 5);
        a.SquareArea(6);
        a.CircleArea(7);
    }
}
