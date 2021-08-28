import java.util.*;
class huisu3 {
    public static void main(String[] args){
        int[] nums={1,2,3,5,4,3,2,1,1,3,4,5,7};
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int target=7;
        res=combinationSum2(nums,7);
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }

    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if(candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        comSum2(candidates,target,0,new LinkedList<Integer>(),result);
        return result;

    }
    public static void comSum2(int[] candidates, int target, int index, LinkedList<Integer> trace,List<List<Integer>> result){
        //满足结束条件
        if(target == 0){
            result.add(new LinkedList(trace));
        }
        if(target > 0){
            //选择列表，并加上约束
            for(int i = index; i<candidates.length; i++){
                //如果以当前结点为头结点的所有组合都找完了，那么下一个与他他相同的头结点就不用去找了。
                if(i > index && candidates[i] == candidates[i - 1]) continue;
                //做出选择
                trace.add(candidates[i]);
                comSum2(candidates,target - candidates[i],i+1,trace,result);
                //撤销选择
                trace.removeLast();
            }
        }
    }
}
