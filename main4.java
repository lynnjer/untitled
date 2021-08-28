import java.util.Arrays;
import java.util.Scanner;

public class main4 {
    public static void main(String[] arges) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int []res=find(nums);
        System.out.print(Arrays.toString(res));
    }
    public static int[] find(int[] array) {
        int []res=new int[3];
        int start=0;
        int end=0;
        int sum = array[0];
        int maxSum = sum;
        for (int i=1, len=array.length; i<len; i++) {
            int curSum = sum + array[i];
            if (curSum>maxSum){
                end=i;
                maxSum=curSum;
            }
            if (curSum<0){
                start=i+1;
                sum=0;
            }
        }
        res[0]=start;
        res[1]=end;
        res[2]=maxSum;
        return res;
    }
}
