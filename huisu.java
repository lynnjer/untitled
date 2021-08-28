import java.util.*;
public class huisu {
//    public static void main(String[] args){
//        int[] nums={1,2,3};
//        List<List<Integer>> res=new ArrayList<>();
//        List<Integer> temp=new ArrayList<>();
//        int target=5;
////        res=combinationSum(nums,7);
//        dfs(0,nums,5,res,temp);
//        for (int i=0;i<res.size();i++){
//            System.out.println(res.get(i));
//        }
//
//    }
//    public static void dfs(int n,int[]nums,int target,List<List<Integer>> res,List<Integer> temp) {
//        if (target == 0) {
//            res.add(new ArrayList<>(temp));
//        }
//        if(target>0) {
//            for (int i = n; i < nums.length; i++) {
////            if(i>n&&nums[i-1]==nums[i]){
////                continue;
////            }
//                temp.add(nums[i]);
//                dfs(i , nums, target - nums[i], res, temp);//………………^_^注意i填成n的后果：位置不一样的也会当成新组合输出
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }
//    public static List<List<Integer>> combinationSum(int[] bb, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (bb == null) {
//            return res;
//        }
//
//        addCombinations(bb, 0, target, new ArrayList<Integer>(), res);
//
//        return res;
//    }
//
//    private static void addCombinations(int[] bb, int start, int target, List<Integer> cache, List<List<Integer>> res) {
//        if (target < 0) {
//            return;
//        }
//        if (target == 0) {
//            res.add(new ArrayList<>(cache));
//            return;
//        }
//        for (int i=start; i<bb.length; i++) {
//            cache.add(bb[i]);
//            addCombinations(bb,i,target-bb[i],cache,res);
//            cache.remove(cache.size()-1);
//        }
//    }
public static void main(String[] args){
    char[] nums={'1','2','3'};//不能有重复
    List<List<Character>> res=new ArrayList<>();
    List<Character> temp=new ArrayList<>();
//        res=combinationSum(nums,7);
    dfs(0,nums,res,temp);
    System.out.println(res.size());
    for (int i=0;i<res.size();i++){
        System.out.println(res.get(i));
    }

}
    public static void dfs(int n,char[]nums,List<List<Character>> res,List<Character> temp) {
        if (temp.size()==3) {
            res.add(new ArrayList<>(temp));
        }
        if(temp.size()<3) {
            for (int i = n; i < nums.length; i++) {
                temp.add(nums[i]);
                dfs(i, nums, res, temp);//………………^_^注意i填成n的后果：位置不一样的也会当成新组合输出 注意不用加一
                temp.remove(temp.size() - 1);
            }
        }
    }
}
