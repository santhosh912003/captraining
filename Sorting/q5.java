public class q5 {
    public static void main(String[] args) {
        int[] scores = {78, 56, 89, 99, 65};
        for (int i = 0; i < scores.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[min]) min = j;
            }
            int t = scores[i]; scores[i] = scores[min]; scores[min] = t;
        }
        for (int s : scores) System.out.print(s + " ");
    }
}