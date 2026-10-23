public class PrecedencePuzzleSolver {
    public static void main(String[] args) {
        int x = 4;
        int y = 2;

        // Puzzle 1: Evaluates postfix x++ (4) against (y * 2 = 4). Since 4 > 4 is false, result is false (x becomes 5).
        // Predicted result: false
        boolean result1 = x++ > y * 2;
        System.out.println("Puzzle 1 Result: " + result1);

        // Puzzle 2: Multiplication runs first (5 * 2 = 10), giving 20 > 18 (true). Right side gives 4 == 4 (true). Both true makes it true.
        // Predicted result: true
        boolean result2 = 10 + 5 * 2 > 18 && 8 / 2 == 4;
        System.out.println("Puzzle 2 Result: " + result2);

        // Puzzle 3: Prefix ++y increments y to 3 first. 15 - 3 = 12 <= 10 is false. Right side x == 5 is true. false || true evaluates to true.
        // Predicted result: true
        boolean result3 = 15 - ++y <= 10 || x == 5;
        System.out.println("Puzzle 3 Result: " + result3);

        /*
         * Precedence Order Note:
         * Increments (++ / --) execute first, followed by arithmetic (*, /, +, -), 
         * then relational operators (>, <=, ==), and finally logical operators (&&, ||).
         */
    }
}
