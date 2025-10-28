import btech.Student;
import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll no := ");
        int roll = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.print("Enter Name := ");
        String name = sc.nextLine();

        System.out.print("Enter 3 sub mark := ");
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();

        Student s = new Student(roll, name, m1, m2, m3);
        s.display();
    }
}
