public class h1{
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, -2, -2, 1};

        System.out.println("Subarrays with zero sum:");
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    System.out.print("From index " + i + " to " + j + " → ");
                    for (int k = i; k <= j; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}