import java.util.*;

public class h3{
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7,4,98,4,3,2,1};
        int result = Subsequence(arr);
        System.out.println("The longest consecutive subsequence" + " "+ result);
    }

    public static int Subsequence(int[] nums) {
        int cnt = 1;
        int longest = 0;
        for(int i=1;i<nums.length;i++){
          if(Math.abs(nums[i]-nums[i-1])==1){
            cnt++;
          }
          else{
            longest = Math.max(longest,cnt);
            
            cnt = 1;
          }
        }
        longest = Math.max(longest,cnt);
        
        return longest;
    }
}