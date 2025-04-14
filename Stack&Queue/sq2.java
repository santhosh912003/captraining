import java.util.*;

class sq2 {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(30);
        st.push(-5);
        st.push(18);
        st.push(14);
        st.push(-3);

        System.out.println("Original Stack: " + st);

        sortStack(st);

        System.out.println("Sorted Stack: " + st);
    }

    
    static void sortStack(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int val = st.pop();
            sortStack(st);
            insertStack(st, val);
        }
    }

    
    static void insertStack(Stack<Integer> st, int val) {
        if (st.isEmpty() || st.peek() <= val) {
            st.push(val);
            return;
        }

        int temp = st.pop();
        insertStack(st, val);
        st.push(temp);
    }
}