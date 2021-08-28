public class duochong {
    private static final int N = 3;
    private static final int V = 5;
    private int weight[] = {0,3,2,2};
    private int Value[] = {0,5,10,20};
    private int nums[] = {0,1,2,0};
    private int f[][]=new int[N+1][V+1];

    public int Completeknapsack()
    {
        //边界条件，第0行和第0列的值设为0
        for (int i = 0;i <= N;i++){
            f[i][0] = 0;
        }
        for (int v = 0;v <= V;v++){
            f[0][v] = 0;
        }
        //递推
        for (int i = 1;i <= N;i++){
            for (int v = 1;v <= V;v++){
                f[i][v] = f[i-1][v];
                int nCount = v / weight[i];
                //最多可以放nCount个物品i
                //和01背包的区别就在这里，01背包只有两种状态：放与不放
                //而完全背包可以放0到k个物品i，同样是取最大值
                for (int k = 0;k <= Math.min(nums[i],nCount);k++){
                    f[i][v] = Math.max(f[i][v],f[i - 1][v - k * weight[i]] + k * Value[i]);
                }
            }
        }
        return f[N][V];
    }
    public static void main(String[] args) {
//        System.out.println(new duochong().Completeknapsack());
        Integer a=200;
        int b=200;
        System.out.print(a==b);

    }
}
