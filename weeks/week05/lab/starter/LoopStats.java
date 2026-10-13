import java.util.Scanner;

public class LoopStats {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = input.nextInt();

        int counter = 1;
        int sum = 0;
        while (counter <= n) {
            sum += counter;
            counter++;
        }
        System.out.println("Sum 1..N = " + sum);

        System.out.println("Multiplication table for " + n);
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }

        input.close();
    }
}
