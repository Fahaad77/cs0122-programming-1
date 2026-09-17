import java.util.Scanner;

public class StudentProfile {
  public static void main(String[] args) {
    final String COURSE_CODE = "CS0122";
    Scanner input = new Scanner(System.in);

    System.out.print("Student name: ");
    String name = input.nextLine();

    System.out.print("Age: ");
    int age = input.nextInt();
    input.nextLine();

    System.out.print("Section: ");
    String section = input.nextLine();

    System.out.print("Expected GPA: ");
    double expectedGpa = input.nextDouble();

    boolean setupComplete = true;

    System.out.println("Course: " + COURSE_CODE);
    System.out.println("Student: " + name);
    System.out.println("Age: " + age);
    System.out.println("Section: " + section);
    System.out.println("Expected GPA: " + expectedGpa);
    System.out.println("Setup complete: " + setupComplete);

    input.close();
  }
}
