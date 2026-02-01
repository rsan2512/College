import java.util.Scanner;

class q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String string = sc.next();
		StringBuilder reversed = new StringBuilder(string).reverse();
		System.out.println("Reversed String is: " + reversed);
		
		if (string.equals(reversed)) {
			System.out.println(string + " is a palindrome");
		} else {
			System.out.println(string + " is not a palindrome");
		}
	}
}