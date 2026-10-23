import java.util.Scanner;

public class GradeThresholdChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter average grade: ");
        double grade = scan.nextDouble();

        System.out.print("Enter number of absences: ");
        int absences = scan.nextInt();

        boolean isPassed = (grade >= 75 && absences <= 3) || (grade >= 90);

        System.out.println();
        System.out.println("Status: " + (isPassed ? "PASS" : "FAIL"));
        
        if (grade >= 90) {
            System.out.println("Reason: Excellent grade (90 or higher) grants automatic pass regardless of absences.");
        } else if (grade >= 75 && absences <= 3) {
            System.out.println("Reason: Grade is at least 75 with 3 or fewer absences.");
        } else if (grade >= 75 && absences > 3) {
            System.out.println("Reason: Failed due to excessive absences (more than 3), despite passing grade.");
        } else {
            System.out.println("Reason: Grade is below the required 75 threshold.");
        }

        scan.close();
    }
}
