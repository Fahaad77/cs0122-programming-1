import java.util.Scanner;

public class GradesArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] grades = new int[5];
        int sum = 0;

        for (int i = 0; i < grades.length; i++) {
            System.out.print("Grade " + (i + 1) + ": ");
            grades[i] = input.nextInt();
        }

        System.out.println("Stored grades:");
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Index " + i + " = " + grades[i]);
            sum += grades[i];
        }

        double average = (double) sum / grades.length;
        System.out.printf("Average: %.2f%n", average);
        input.close();
    }
}
