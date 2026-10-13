import java.util.Scanner;

public class MenuSelection {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your GPA: ");
        double gpa = input.nextDouble();
        input.nextLine();

        String category;
        if (gpa < 0 || gpa > 5) {
            category = "Invalid GPA";
        } else if (gpa >= 4.5) {
            category = "Excellent";
        } else if (gpa >= 3.75) {
            category = "Very good";
        } else if (gpa >= 2.75) {
            category = "Good";
        } else if (gpa >= 2.0) {
            category = "Pass";
        } else {
            category = "At risk";
        }
        System.out.println("Category: " + category);

        System.out.println("1. Burger");
        System.out.println("2. Pasta");
        System.out.println("3. Salad");
        System.out.print("Choose a meal number: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Burger selected");
                break;
            case 2:
                System.out.println("Pasta selected");
                break;
            case 3:
                System.out.println("Salad selected");
                break;
            default:
                System.out.println("Invalid meal choice");
        }

        input.close();
    }
}
