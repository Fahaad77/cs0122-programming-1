import java.util.Scanner;

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] temperatures = new double[7];
        double sum = 0;

        for (int i = 0; i < temperatures.length; i++) {
            System.out.print("Temperature day " + (i + 1) + ": ");
            temperatures[i] = input.nextDouble();
            sum += temperatures[i];
        }

        double min = temperatures[0];
        double max = temperatures[0];
        int aboveThirty = 0;

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] < min) min = temperatures[i];
            if (temperatures[i] > max) max = temperatures[i];
            if (temperatures[i] >= 30) aboveThirty++;
        }

        System.out.printf("Average: %.2f%n", sum / temperatures.length);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Days >= 30: " + aboveThirty);
        input.close();
    }
}
