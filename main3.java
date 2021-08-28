import java.util.Scanner;

public class main3 {
    public static void main(String[] arges) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m=sc.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int max=0;
        if (m==1){
            max=find(nums);
            System.out.print(max);
        }else {
            int length=2*n;
            int[] nums2=new int[length];
            for (int i=0;i<n;i++){
                nums2[i]=nums[i];
            }
            for (int i=n;i<length;i++){
                nums2[i]=nums[i-n];
            }
            if (m==2){
                max=find(nums2);
                System.out.print(max);
            }else {
                int count=0;
                for (int i=0;i<n;i++){
                    count+=nums[i];
                }
                if (count<0){
                    max=find(nums2);
                    System.out.print(max);
                }else {
                    max=find(nums2);
                    max+=(m-2)*count;
                    System.out.print(max);
                }
            }

        }
    }

    public static int find(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int sum = array[0];
        int maxSum = sum;
        for (int i=1, len=array.length; i<len; i++) {
            int curSum = sum + array[i];
            maxSum = Math.max(maxSum, curSum);
            sum = curSum < 0 ? 0 : curSum;
        }
        return maxSum;
    }


}