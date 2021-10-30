import java.util.*;

public class BackTrack {
    public static void main(String[] args) {

    }

    // leetcode 1947
    public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
        Map<Integer, int[]> map1 = new HashMap<>();
        Map<Integer, int[]> map2 = new HashMap<>();
        for (int i = 0; i < students.length; i++) {
            map1.put(i, students[i]);
            map2.put(i, mentors[i]);
        }
    }
}