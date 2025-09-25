package Java.a5;

abstract class FigureQ4 {
    double dim1, dim2;
    FigureQ4(double d1, double d2) {
        dim1 = d1;
        dim2 = d2;
    }
    abstract double getArea();
}

class RectangleQ4 extends FigureQ4 {
    RectangleQ4(double d1, double d2) {
        super(d1, d2);
    }
    double getArea() {
        return dim1 * dim2;
    }
}

class TriangleQ4 extends FigureQ4 {
    TriangleQ4(double d1, double d2) {
        super(d1, d2);
    }
    double getArea() {
        return 0.5 * dim1 * dim2;
    }
}

public class q4 {
    public static void main(String[] args) {
        FigureQ4 f;
        f = new RectangleQ4(10, 20);
        System.out.println("Area of Rectangle: " + f.getArea());
        f = new TriangleQ4(10, 20);
        System.out.println("Area of Triangle: " + f.getArea());
    }
}
