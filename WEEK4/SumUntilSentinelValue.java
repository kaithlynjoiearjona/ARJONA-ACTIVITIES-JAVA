
import java.util.Scanner;

public class SumUntilSentinelValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number;
        int sum = 0;

        System.out.print("Enter an integer (-1 to stop): ");
        number = input.nextInt();

        while (number != -1) {
            sum += number;

            System.out.print("Enter an integer (-1 to stop): ");
            number = input.nextInt();
        }

        System.out.println("Total sum: " + sum);

        input.close();
    }
}
