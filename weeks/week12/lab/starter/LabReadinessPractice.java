import java.util.Scanner;

public class LabReadinessPractice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] values = new int[6];

        for (int i = 0; i < values.length; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            values[i] = input.nextInt();
        }

        int evenCount = 0;
        int total = 0;
        for (int value : values) {
            total += value;
            if (value % 2 == 0) {
                evenCount++;
            }
        }

        System.out.println("Total: " + total);
        System.out.println("Even count: " + evenCount);
        System.out.printf("Average: %.2f%n", (double) total / values.length);
        input.close();
    }
}
