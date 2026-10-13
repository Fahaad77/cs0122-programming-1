import java.util.Scanner;

public class RepeatingMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Print table");
            System.out.println("2. Find first divisor");
            System.out.println("3. Skip negatives in sample data");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    for (int row = 1; row <= 5; row++) {
                        for (int col = 1; col <= 5; col++) {
                            System.out.printf("%4d", row * col);
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Number: ");
                    int number = input.nextInt();
                    for (int d = 2; d <= number; d++) {
                        if (number % d == 0) {
                            System.out.println("First divisor: " + d);
                            break;
                        }
                    }
                    break;
                case 3:
                    int[] values = {4, -2, 7, -9, 3};
                    for (int value : values) {
                        if (value < 0) {
                            continue;
                        }
                        System.out.println("Accepted: " + value);
                    }
                    break;
                case 0:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

        input.close();
    }
}
