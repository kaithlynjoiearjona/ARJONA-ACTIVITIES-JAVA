public class OverflowAndReferenceInvestigator {
    public static void main(String[] args) {
        // --- 1. Primitive Overflow ---
        short capacity = 32767;
        capacity++; // Exceeding Short.MAX_VALUE wraps around to Short.MIN_VALUE (-32768)

        System.out.println("Overflow Output: " + capacity);
        System.out.println();

        // --- 2. String Comparisons ---
        String text1 = "Information System";
        String text2 = new String("Information System");
        String text3 = new String("Information System");

        /*
         * Output: false
         * Reason: text1 points to a string in the String Constant Pool, while text2 
         * refers to an object in heap memory. Using == compares memory addresses, not content.
         */
        System.out.println("text1 == text2: " + (text1 == text2));

        /*
         * Output: false
         * Reason: text2 and text3 were both created with 'new', which allocates two 
         * distinct memory locations in the heap, so their references do not match.
         */
        System.out.println("text2 == text3: " + (text2 == text3));

        /*
         * Output: true
         * Reason: text1 and text3 are compared using .equals(), which compares the 
         * actual characters inside the strings rather than their locations in memory.
         */
        System.out.println("text1.equals(text3): " + text1.equals(text3));
        System.out.println();

        // --- 3. Shared Array Reference ---
        String[] primaryList = {"Java", "Python", "C++"};
        String[] secondaryList = primaryList; // Pointing to the same memory location

        secondaryList[1] = "C#"; // Modifying through the second variable

        System.out.println("primaryList[1]: " + primaryList[1]);
        System.out.println("secondaryList[1]: " + secondaryList[1]);
    }
}
