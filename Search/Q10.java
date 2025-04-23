package Search;
public class Q10 {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, -1, 7, 9};
        System.out.println(findFirstNegative(arr));  
    }
}