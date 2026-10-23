import java.util.Scanner;

public class FourFunctionCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        System.out.println("\n--- Arithmetic Results ---");
        System.out.println("Addition (+):        " + (num1 + num2));
        System.out.println("Subtraction (-):     " + (num1 - num2));
        System.out.println("Multiplication (*):  " + (num1 * num2));
        System.out.println("Division (/):        " + (num1 / num2));
        System.out.println("Modulo (%):          " + (num1 % num2));

        /*
         * Note on Negative Operands:
         * Division (/) truncates toward zero when negative numbers are used (e.g., -7 / 2 = -3).
         * Modulo (%) takes the sign of the dividend (left operand). For example, -7 % 3 gives -1,
         * whereas 7 % -3 gives 1.
         */

        input.close();
    }
}
