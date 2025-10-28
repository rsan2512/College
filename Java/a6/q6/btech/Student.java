
package btech;
import java.util.*;

public class Student {
    int roll;
    String name;
    int m1, m2, m3;

    // Parameterized Constructor
    public Student(int roll, String name, int m1, int m2, int m3) {
        this.roll = roll;
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    // Display Method
    public void display() {
        int total = m1 + m2 + m3;
        float percentage = total / 3.0f;

        System.out.println("Roll_no : " + roll);
        System.out.println(name);
        System.out.println("MARKS");
        System.out.println("Sub 1 : " + m1);
        System.out.println("Sub 2 : " + m2);
        System.out.println("Sub 3 : " + m3);
        System.out.println("Total : " + total);
        System.out.println("Percentage : " + percentage);
    }
}
