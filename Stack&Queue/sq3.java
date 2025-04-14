import java.util.*;
public class sq3 {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = new int[prices.length];
        Stack<Integer> stack = new Stack<>(); 
        for (int i = 0; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {               
                span[i] = i - stack.peek();
            }     
            stack.push(i);
        }
        System.out.println("Stock Prices: " + Arrays.toString(prices));
        System.out.println("Spans:        " + Arrays.toString(span));
    }
}
