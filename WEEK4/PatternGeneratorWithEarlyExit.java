import java.util.Scanner;

public class PatternGeneratorWithEarlyExit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter grid size (e.g., 5): ");
        String sizeInput = scan.nextLine().trim();
        int size = Integer.parseInt(sizeInput);

        System.out.println("\nGenerated Pattern:");

        for (int row = 1; row <= size; row++) {
            // Demonstration of continue: skips printing row 3 completely
            if (row == 3) {
                continue;
            }

            for (int col = 1; col <= row; col++) {
                // Demonstration of break: stops inner loop if column exceeds 4
                if (col > 4) {
                    break;
                }
                System.out.print("* ");
            }
            System.out.println();
        }

        scan.close();
    }
}
