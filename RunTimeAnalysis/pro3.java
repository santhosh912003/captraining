public class pro3 {
    public static void main(String[] args) {
        int n = 1000000;
        String str = "a";

        long startTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str; 
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time using String: " + (endTime - startTime) + " ms");

        
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time using StringBuilder: " + (endTime - startTime) + " ms");

        
        startTime = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time using StringBuffer: " + (endTime - startTime) + " ms");
    }
}