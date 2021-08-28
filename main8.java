import java.lang.reflect.Array;
import java.util.*;


public class main8 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String a=in.nextLine();
        String[] nums=a.split(" ");
        int []nums1=new int[nums.length];
       for (int i=0;i<nums.length;i++){
           nums1[i]=Integer.valueOf(nums[i]);
       }
       int res=subsequence(nums.length,nums1);
       System.out.println(res);
    }
    public static int  subsequence (int n, int[] array) {
        int[] dp = new int[n];
        dp[0] = array[0];
        dp[1] = Math.max(dp[0],array[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+array[i]);
        }
        return dp[n-1];
    }
}
