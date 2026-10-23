import java.util.Arrays;

public class SearchAndSortMiniTool {
    public static void main(String[] args) {
        int[] originalScores = {88, 92, 75, 64, 95, 81, 70, 89};
        int targetScore = 81;

        // --- Linear Search on Original Array ---
        int foundIndex = -1;
        for (int i = 0; i < originalScores.length; i++) {
            if (originalScores[i] == targetScore) {
                foundIndex = i;
                break;
            }
        }

        System.out.println("--- Search Result ---");
        if (foundIndex != -1) {
            System.out.println("Target score " + targetScore + " found at index: " + foundIndex);
        } else {
            System.out.println("Target score " + targetScore + " was not found.");
        }

        // --- Sort a Copy of the Array ---
        int[] sortedScores = Arrays.copyOf(originalScores, originalScores.length);
        Arrays.sort(sortedScores);

        // --- Print Both Arrays ---
        System.out.println("\n--- Array Comparison ---");
        System.out.print("Original Array: ");
        printArray(originalScores);

        System.out.print("Sorted Array:   ");
        printArray(sortedScores);

        /*
         * Why sorting a copy matters:
         * 1. Preserves Original Data: The original sequence might represent historical records or student ID order.
         * 2. Index Integrity: Index locations in the original array correspond to specific entries/students. 
         *    Sorting directly mutates the original reference, rendering original index mappings invalid.
         */
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
