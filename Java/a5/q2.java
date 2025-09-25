package Java.a5;

class Figure {
    double dim1, dim2;
    Figure(double d1, double d2) {
        dim1 = d1;
        dim2 = d2;
    }   double area() {
        System.out.println("Area of Figure not defined");
        return 0;
    } }
class Rectangle extends Figure {
    Rectangle(double l, double b) {
        super(l, b); 
    }    double area() {
        return dim1 * dim2;
    }  }
class Triangle extends Figure {
    Triangle(double b, double h) {
        super(b, h);
    }    double area() {
        return 0.5 * dim1 * dim2;
    }   }
class Square extends Figure {
    Square(double side) {
        super(side, side); // Square has equal sides
    }    double area() {
        return dim1 * dim2;
    }   }
public class q2 {
    public static void main(String[] args) {
       Figure f;
        f = new Rectangle(5, 10);
        System.out.println("Area of Rectangle: " + f.area());
        f = new Triangle(6, 8);
        System.out.println("Area of Triangle: " + f.area());
        f = new Square(7);
        System.out.println("Area of Square: " + f.area());
    }
}
