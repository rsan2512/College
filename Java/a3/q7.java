package Java.a3;

public class q7 {
   
    public static void main(String[] args) {
        String sic = args[0], name = args[1], branch = args[2];
        double sum = 0;

        for (int i = 3; i < 9; i++) {
            sum += Double.parseDouble(args[i]);
        }
        double avg = sum / 6;

        System.out.println("SIC: " + sic);
        System.out.println("Name: " + name);
        System.out.println("Branch: " + branch);
        System.out.println("Average Marks: " + avg);
    }
}

