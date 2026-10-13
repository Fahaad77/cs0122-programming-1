import java.util.Scanner;

public class GradeManagementProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] scores = new int[5];

        for (int i = 0; i < scores.length; i++) {
            System.out.print("Score for student " + (i + 1) + ": ");
            scores[i] = input.nextInt();
        }

        int choice;
        do {
            System.out.println("1. Display scores");
            System.out.println("2. Show average");
            System.out.println("3. Count pass/fail");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < scores.length; i++) {
                        System.out.println("Student " + (i + 1) + ": " + scores[i]);
                    }
                    break;
                case 2:
                    int total = 0;
                    for (int score : scores) {
                        total += score;
                    }
                    System.out.printf("Average: %.2f%n", (double) total / scores.length);
                    break;
                case 3:
                    int pass = 0;
                    for (int score : scores) {
                        if (score >= 60) {
                            pass++;
                        }
                    }
                    System.out.println("Pass: " + pass);
                    System.out.println("Fail: " + (scores.length - pass));
                    break;
                case 0:
                    System.out.println("Project closed.");
                    break;
                default:
                    System.out.println("Invalid menu choice.");
            }
        } while (choice != 0);
        input.close();
    }
}
