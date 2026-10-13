import java.util.Scanner;

public class ProjectPolish {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = new String[3];
        int[] scores = new int[3];

        for (int i = 0; i < names.length; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = input.nextLine();
            System.out.print("Score: ");
            scores[i] = input.nextInt();
            input.nextLine();
        }

        System.out.println("Report");
        for (int i = 0; i < names.length; i++) {
            String status = scores[i] >= 60 ? "Pass" : "Needs support";
            System.out.println(names[i] + " - " + scores[i] + " - " + status);
        }
        input.close();
    }
}
