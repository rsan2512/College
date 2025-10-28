
import java.util.*;
import org.shapes.*;

public class TestShapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChoose a shape:");
            System.out.println("1. Square");
            System.out.println("2. Circle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter side of square: ");
                    double s = sc.nextDouble();
                    Square sq = new Square(s);
                    System.out.println("Area = " + sq.area());
                    System.out.println("Perimeter = " + sq.perimeter());
                    break;

                case 2:
                    System.out.print("Enter radius of circle: ");
                    double r = sc.nextDouble();
                    Circle c = new Circle(r);
                    System.out.println("Area = " + c.area());
                    System.out.println("Perimeter = " + c.perimeter());
                    break;

                case 3:
                    System.out.print("Enter 3 sides of triangle: ");
                    double a = sc.nextDouble();
                    double b = sc.nextDouble();
                    double c3 = sc.nextDouble();
                    Triangle t = new Triangle(a, b, c3);
                    System.out.println("Area = " + t.area());
                    System.out.println("Perimeter = " + t.perimeter());
                    break;

                case 4:
                    System.out.println("Exiting... Bye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 4);
    }
}
