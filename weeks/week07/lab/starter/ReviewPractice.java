import java.util.Scanner;

public class ReviewPractice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        int total = 0;
        int value;

        System.out.println("Enter positive numbers. Enter 0 to stop.");
        System.out.print("Value: ");
        value = input.nextInt();

        while (value != 0) {
            if (value > 0) {
                total += value;
                count++;
            }
            System.out.print("Value: ");
            value = input.nextInt();
        }

        if (count > 0) {
            double average = (double) total / count;
            System.out.printf("Average: %.2f%n", average);
        } else {
            System.out.println("No positive values entered.");
        }
        input.close();
    }
}
