package Java.a2;

import java.util.Scanner;

public class q2 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your marks in English: ");
        double english = sc.nextDouble();
        System.out.print("Enter your marks in Maths: ");
        double maths = sc.nextDouble();
        System.out.print("Enter your marks in Science: ");
        double science = sc.nextDouble();
        System.out.print("Enter your marks in Computer: ");
        double computer = sc.nextDouble();
        double average = (english + maths + science + computer) / 4;
        String grade;

        if (average > 90) {
            grade = "O";
        } else if (average > 80) {
            grade = "E";
        } else if (average > 70) {
            grade = "A";
        } else if (average > 60) {
            grade = "B";
        } else if (average > 50) {
            grade = "C";
        } else {
            grade = "F";
        }
        System.out.println("Your grade is " + grade);
    }
}
