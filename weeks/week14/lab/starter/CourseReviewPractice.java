public class CourseReviewPractice {
    public static void main(String[] args) {
        int[] values = {4, 8, 15, 16, 23, 42};
        int target = 16;
        boolean found = false;

        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                System.out.println("Found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Target not found");
        }
    }
}
