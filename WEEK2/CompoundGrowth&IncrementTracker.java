public class CompoundGrowthAndIncrementTracker {
    public static void main(String[] args) {
        double balance = 1000.0;

        balance += 250.0;
        System.out.println("Balance after deposit: Php " + balance);

        balance *= 1.10;
        System.out.println("Balance after interest growth: Php " + balance);

        balance += 500.0;
        System.out.println("Balance after second deposit: Php " + balance);

        System.out.println();

        int count = 5;

        System.out.println("Postfix (count++): " + count++);
        System.out.println("Value after postfix: " + count);

        System.out.println();

        // ++count increments the variable first before returning its updated value,
        // whereas count++ returns the original value first and then increments afterward.
        System.out.println("Prefix (++count): " + ++count);
        System.out.println("Value after prefix: " + count);
    }
}
