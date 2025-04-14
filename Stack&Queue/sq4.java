import java.util.*;

class sq4 {

    public static List<Integer> maxInWindows(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = 1; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> maxList = maxInWindows(arr, k);
        System.out.println("Maximums in each window:");
        System.out.println(maxList);
    }
}