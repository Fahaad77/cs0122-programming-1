import java.util.Scanner;

public class MatrixProcessor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] sales = new int[3][4];
        int total = 0;

        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                System.out.print("Sales row " + row + ", col " + col + ": ");
                sales[row][col] = input.nextInt();
                total += sales[row][col];
            }
        }

        System.out.println("Matrix:");
        for (int row = 0; row < sales.length; row++) {
            int rowTotal = 0;
            for (int col = 0; col < sales[row].length; col++) {
                System.out.printf("%5d", sales[row][col]);
                rowTotal += sales[row][col];
            }
            System.out.println(" | row total = " + rowTotal);
        }

        System.out.println("Overall total: " + total);
        input.close();
    }
}
