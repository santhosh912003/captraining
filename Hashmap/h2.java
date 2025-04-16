import java.util.*;

public class h2 {
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair exists!");
        } else {
            System.out.println("No such pair found.");
        }
    }

    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                System.out.println("Pair: " + num + " + " + complement + " = " + target);
                return true;
            }
            set.add(num);
        }

        return false;
    }
}