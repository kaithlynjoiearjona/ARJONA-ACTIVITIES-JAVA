public class ClassRankingSystem {

    static class Student {
        String name;
        int[] quizzes;
        double average;

        public Student(String name, int[] quizzes) {
            this.name = name;
            this.quizzes = quizzes;
            this.average = calculateAverage();
        }

        private double calculateAverage() {
            int sum = 0;
            for (int score : quizzes) {
                sum += score;
            }
            return (double) sum / quizzes.length;
        }
    }

    public static void main(String[] args) {
        String[] names = {"Maria", "Joie", "Alex", "Bea", "Carlos"};
        int[][] quizData = {
            {85, 90, 88, 92}, // Maria: Avg = 88.75
            {95, 92, 98, 95}, // Joie:  Avg = 95.00
            {78, 82, 80, 84}, // Alex:  Avg = 81.00
            {95, 92, 98, 95}, // Bea:   Avg = 95.00 (Tied with Joie)
            {88, 85, 90, 89}  // Carlos:Avg = 88.00
        };

        Student[] students = new Student[names.length];
        for (int i = 0; i < names.length; i++) {
            students[i] = new Student(names[i], quizData[i]);
        }

        sortStudentsByAverage(students);

        // Display Leaderboard
        System.out.println("==================================================");
        System.out.println("               CLASS LEADERBOARD                  ");
        System.out.println("==================================================");
        System.out.printf("%-6s %-10s %-20s %-8s\n", "Rank", "Name", "Quiz Scores", "Average");
        System.out.println("--------------------------------------------------");

        int[] ranks = new int[students.length];
        int currentRank = 1;

        for (int i = 0; i < students.length; i++) {
            if (i > 0 && students[i].average == students[i - 1].average) {
                ranks[i] = ranks[i - 1];
            } else {
                ranks[i] = currentRank;
            }
            currentRank++;

            String scoresStr = "";
            for (int j = 0; j < students[i].quizzes.length; j++) {
                scoresStr += students[i].quizzes[j] + (j < students[i].quizzes.length - 1 ? ", " : "");
            }

            System.out.printf("#%-5d %-10s [%-18s] %-8.2f\n", ranks[i], students[i].name, scoresStr, students[i].average);
        }
        System.out.println("==================================================\n");

        String searchTarget = "Joie";
        int foundRank = findStudentRank(students, ranks, searchTarget);

        System.out.println("--- Search Result ---");
        if (foundRank != -1) {
            System.out.println("Student \"" + searchTarget + "\" is ranked #" + foundRank + " on the leaderboard.");
        } else {
            System.out.println("Student \"" + searchTarget + "\" was not found in the records.");
        }
    }

    public static void sortStudentsByAverage(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].average < students[j + 1].average) {
                    // Swap elements
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }


    public static int findStudentRank(Student[] students, int[] ranks, String targetName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].name.equalsIgnoreCase(targetName)) {
                return ranks[i];
            }
        }
        return -1; // Not found
    }
}
