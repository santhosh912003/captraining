import java.util.*;

public class h5{
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        if (TwoSum(arr, target)) {
            System.out.println("Two sum pair exists!");
        } else {
            System.out.println("No such pair found.");
        }
    }

    public static boolean TwoSum(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for (int num : arr) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                System.out.println("Pair: " + num + " + " + complement + " = " + target);
                return true;
            }
            map.put(num,index++);
        }

        return false;
    }
}