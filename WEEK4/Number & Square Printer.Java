public class NumberSquarePrinter {
    public static void main(String[] args) {
        int limit = 10; 

        System.out.println("Number\tSquare");
        System.out.println("----------------");

        for (int i = 1; i <= limit; i++) {
            int square = i * i;
            System.out.println(i + "\t" + square);
        }
    }
}
