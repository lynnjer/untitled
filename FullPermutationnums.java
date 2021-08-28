import java.util.*;
public class FullPermutationnums {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, res, list, visited);
        return res;
    }

    public void helper(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new LinkedList(list));
//            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(nums, res, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
