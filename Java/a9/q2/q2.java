import java.util.Scanner;

class q2{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a sentence: ");
		String string = sc.nextLine();
		StringBuilder stringBuilder = new StringBuilder(string.length());
		
		for (String word : string.split(" ")) {
			stringBuilder.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(' ');
		}
		System.out.println("Transformed String is: " + stringBuilder);
	}
}
