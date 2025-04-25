public class q1 {
    public static void main(String[] args) {
        int[] marks = {85, 72, 93, 60, 77};
        for (int i = 0; i < marks.length - 1; i++) {
            for (int j = 0; j < marks.length - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
        for (int m : marks) System.out.print(m + " ");
    }
}