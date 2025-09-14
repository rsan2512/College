package Java.a4;

/*	Q8. Design a class ‘Complex’ to manipulate Complex numbers having data members as real and imag. The class should have a parameterized
        constructor to initialize its data members. It should also have methods display() to display the complex number (in the format 5+3i for
        example), add() to add two Complex numbers. Test these methods by creating main method in another class.
 */

import java.util.Scanner;

class ComplexNum {
    private double real, imag;

    public ComplexNum(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public void display() {
        System.out.println(real + "+" + imag + "i");
    }

    public static ComplexNum add(ComplexNum complex1, ComplexNum complex2) {
        return new ComplexNum(complex1.real + complex2.real, complex1.imag + complex2.imag);
    }
}

class q8 {
    public static void main(String[] args) {
        ComplexNum complex1 = createComplex("first");
        ComplexNum complex2 = createComplex("second");
        System.out.println("The two complex numbers are: ");
        complex1.display();
        complex2.display();
        ComplexNum sum = ComplexNum.add(complex1, complex2);
        System.out.print("Sum of two complex numbers is: ");
        sum.display();
    }

    private static ComplexNum createComplex(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter real and imag for " + name + " complex number: ");
        double real = sc.nextDouble();
        double imag = sc.nextDouble();
        return new ComplexNum(real, imag);
        
    }
}