public class q7 {
    public static void main(String[] args) {
        int[] ages = {14, 12, 16, 11, 15, 10, 13};
        int max = 18, min = 10;
        int[] count = new int[max - min + 1];
        for (int a : ages) count[a - min]++;
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) ages[index++] = i + min;
        }
        for (int a : ages) System.out.print(a + " ");
    }
}