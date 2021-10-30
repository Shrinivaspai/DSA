import java.util.*;

public class BackTrack {
    public static void main(String[] args) {
        // System.out.println(maxCompatibilitySum(new int[][] { { 1, 1, 0 }, { 1, 0, 1
        // }, { 0, 0, 1 } },
        // new int[][] { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 1, 0 } }));
        // System.out.println();
        System.out.println(maxCompatibilitySum(new int[][] { { 0, 0 }, { 0, 0 }, { 0, 0 } },
                new int[][] { { 1, 1 }, { 1, 1 }, { 1, 1 } }));
    }

    // leetcode 1947
    public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
        backtracking(students, mentors, 0);
        return score;
    }

    static int score = 0;

    static void backtracking(int[][] students, int[][] mentors, int curscore) {
        if (students.length == 0) {
            score = curscore > score ? curscore : score;
            return;
        }
        for (int i = 0; i < students.length; i++) {
            int[][] next = new int[students.length - 1][students[0].length];
            int cnt = 0;
            for (int j = 0; j < students.length; j++) {
                if (i != j) {
                    next[cnt++] = students[j];
                }
            }
            for (int j = 0; j < students.length; j++) {
                int[][] nextMentor = new int[mentors.length - 1][mentors[0].length];
                cnt = 0;
                for (int k = 0; k < mentors.length; k++) {
                    if (i != k) {
                        nextMentor[cnt++] = mentors[k];
                    }
                }
                int scoren = 0;
                for (int val = 0; val < mentors[0].length; val++) {
                    if (mentors[j][val] == students[i][val]) {
                        scoren++;
                    }
                }
                backtracking(next, nextMentor, curscore + scoren);
            }
        }
    }
}