package Java.a5;

class Point2D {
    int x, y;
    Point2D() {
        x = 0;
        y = 0;
    }
    Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    void display() {
        System.out.println("Point2D Coordinates: (" + x + ", " + y + ")");
  }  }
class Point3D extends Point2D {
    int z;
    Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    void show() {
        System.out.println("Point3D Coordinates: (" + x + ", " + y + ", " + z + ")");
   } }
public class q5 {
    public static void main(String[] args) {
        Point2D p1 = new Point2D();
        p1.display();
        Point2D p2 = new Point2D(5, 10);
        p2.display();
        Point3D p3 = new Point3D(3, 6, 9);
        p3.show();
   } }
