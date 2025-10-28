package Java.a6.q7;

import btech.arithmetic.MyMath;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyMath m = new MyMath();

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Addition = " + m.add(a, b));
        System.out.println("Subtraction = " + m.sub(a, b));
        System.out.println("Multiplication = " + m.mul(a, b));
        System.out.println("Division = " + m.div(a, b));
        System.out.println("Modulus = " + m.mod(a, b));
    }
}

