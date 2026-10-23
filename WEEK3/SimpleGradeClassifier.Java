public class SimpleGradeClassifier {
    public static void main(String[] args) {
        int score = 59; 

        if (score >= 60) {
            System.out.println("Score: " + score + " - PASSED");
        } else {
            System.out.println("Score: " + score + " - FAILED");
        }
    }
}
