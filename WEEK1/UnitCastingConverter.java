public class UnitCastingConverter {
    public static void main(String[] args) {
        double totalCm = 185.5;

        // Narrowing cast: double to int (drops fractional value)
        int fullMeters = (int) (totalCm / 100);
        double leftOverCm = totalCm % 100;

        System.out.println("Measurement: " + totalCm + " cm");
        System.out.println("Whole Meters: " + fullMeters);
        System.out.println("Extra Centimeters: " + leftOverCm);
        System.out.println();

        // Implicit Widening
        int wholeValue = 12;
        // Java automatically converts an integer into a double since double has a larger size and precision capacity.
        double widenedValue = wholeValue;
        System.out.println("Widened Value: " + widenedValue);

        // Explicit Narrowing
        double exactCm = 45.89;
        // Casting double to int drops the decimal part completely (.89 is discarded, leaving only the integer portion).
        int narrowedCm = (int) exactCm;
        System.out.println("Narrowed Value: " + narrowedCm);
    }
}
