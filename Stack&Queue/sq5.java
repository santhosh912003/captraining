public class sq5 {
    public static int canCompleteTour(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0;
        int deficit = 0;
        int balance = 0;

        for (int i = 0; i < n; i++) {
            balance += petrol[i] - distance[i];

            
            if (balance < 0) {
                start = i + 1;        
                deficit += balance;   
                balance = 0;           
            }
        }

        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int result = canCompleteTour(petrol, distance);
        if (result == -1) {
            System.out.println("No solution exists.");
        } else {
            System.out.println("Start from petrol pump index: " + result);
        }
    }
}