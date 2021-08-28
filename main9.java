import java.util.*;

public class main9 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int l=in.nextInt();
        HashSet<Long> set=new HashSet<>();
        for (int i=0;i<l;i++){
            long temp=in.nextLong();
            if(!set.contains(temp)){
                set.add(temp);
            }
        }
        long[] array = set.stream().mapToLong(Number::longValue).toArray();
        long res =triangleNumber(array);
        System.out.println(res*2);
    }
        public static long triangleNumber(long[] nums) {
            long count = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int k = i + 2;
                for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                    while (k < nums.length && nums[i] + nums[j] > nums[k]){
                        count=Math.max(nums[k]-nums[i],count);
                        k++;
                    }

                }
            }
            return count;
        }
}



