package Java.a5;

class ShapeQ3 {
    void draw() {
        System.out.println("Drawing Shape");
    }
    void erase() {
        System.out.println("Erasing Shape");
    }
}

class CircleQ3 extends ShapeQ3 {
    void draw() {
        System.out.println("Drawing Circle");
    }
    void erase() {
        System.out.println("Erasing Circle");
    }
}

class TriangleQ3 extends ShapeQ3 {
    void draw() {
        System.out.println("Drawing Triangle");
    }
    void erase() {
        System.out.println("Erasing Triangle");
    }
}

class SquareQ3 extends ShapeQ3 {
    void draw() {
        System.out.println("Drawing Square");
    }
    void erase() {
        System.out.println("Erasing Square");
    }
}

public class q3 {
    public static void main(String[] args) {
        ShapeQ3 s;
        s = new CircleQ3();
        s.draw();
        s.erase();
        s = new TriangleQ3();
        s.draw();
        s.erase();
        s = new SquareQ3();
        s.draw();
        s.erase();
    }
}
